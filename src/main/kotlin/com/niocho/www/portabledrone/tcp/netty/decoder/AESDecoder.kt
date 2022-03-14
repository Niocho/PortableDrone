package com.niocho.www.portabledrone.tcp.netty.decoder

import com.niocho.www.portabledrone.service.drone.DroneService
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder
import org.slf4j.LoggerFactory
import java.net.InetSocketAddress
import java.util.*
import kotlin.math.log

class AESDecoder(private val droneService: DroneService): MessageToMessageDecoder<String>() {
    private val logger = LoggerFactory.getLogger(AESDecoder::class.java)

    override fun decode(ctx: ChannelHandlerContext, msg: String?, out: MutableList<Any>?) {
        msg ?: run {
            return
        }
        var msgWithoutDelimiter = msg.replace("\r\n", "")
        msgWithoutDelimiter = msgWithoutDelimiter.replace("\n", "")
        if (!droneService.exists(ctx.channel())) {
            val authentications = msgWithoutDelimiter.split(" ")
            if (authentications.size < 2) {
                ctx.channel().close()
                return
            }
            val droneIdStr = authentications[0]
            val testMsg = authentications[1]
            try {
                val droneId = droneIdStr.toLong()
                droneService.authenticateDroneWithId(ctx.channel(), droneId, Base64.getDecoder().decode(testMsg.toByteArray(Charsets.US_ASCII)))
                logger.info("drone $droneId authenticated with ip address: ${(ctx.channel().remoteAddress() as InetSocketAddress).hostString} successfully")
            } catch (e: NumberFormatException) {
                ctx.channel().close()
                logger.info("drone authenticated with ip address: ${(ctx.channel().remoteAddress() as InetSocketAddress).hostString} failure: invalid drone id")
                return
            } catch (ex: Exception) {
                ctx.channel().close()
                logger.info("drone $droneIdStr authenticated with ip address: ${(ctx.channel().remoteAddress() as InetSocketAddress).hostString} failure: invalid credentials")
                return
            }
        } else {
            out?.add(Base64.getDecoder().decode(droneService.decrypt(ctx.channel(), Base64.getDecoder().decode(msgWithoutDelimiter.toByteArray(Charsets.US_ASCII)))))
        }
    }
}