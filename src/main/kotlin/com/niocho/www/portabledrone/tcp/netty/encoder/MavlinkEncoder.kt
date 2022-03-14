package com.niocho.www.portabledrone.tcp.netty.encoder

import com.mavlink.Messages.MAVLinkMessage
import com.niocho.www.portabledrone.service.drone.DroneService
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import java.util.*

class MavlinkEncoder(private val droneService: DroneService): MessageToMessageEncoder<MAVLinkMessage>() {
    override fun encode(ctx: ChannelHandlerContext, msg: MAVLinkMessage?, out: MutableList<Any>?) {
        msg ?: return
        val data = Base64.getEncoder().encode(msg.pack().encodePacket())
        val str = "${Base64.getEncoder().encodeToString(droneService.encrypt(ctx.channel(), data))}\n"
        out?.add(str)
    }
}