package com.niocho.www.portabledrone.tcp.netty.decoder

import com.niocho.www.portabledrone.service.drone.DroneService
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder
import java.util.*

class AESDecoder(private val droneService: DroneService): MessageToMessageDecoder<String>() {
    override fun decode(ctx: ChannelHandlerContext, msg: String?, out: MutableList<Any>?) {
        msg ?: run {
            return
        }
        if (!droneService.exists(ctx.channel())) {
            val authentications = msg.split(" ")
            if (authentications.size < 2) {
                ctx.channel().close()
                return
            }
            val droneIdStr = authentications[0]
            val testMsg = authentications[1]
            try {
                val droneId = droneIdStr.toLong()
                droneService.authenticateDroneWithId(ctx.channel(), droneId, Base64.getDecoder().decode(testMsg.toByteArray(Charsets.US_ASCII)))
            } catch (e: NumberFormatException) {
                ctx.channel().close()
                return
            }
        } else {
            out?.add(droneService.decrypt(ctx.channel(), Base64.getDecoder().decode(msg.toByteArray(Charsets.US_ASCII))))
        }
    }
}