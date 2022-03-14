package com.niocho.www.portabledrone.tcp.netty.handler

import com.mavlink.Parser
import com.niocho.www.portabledrone.service.drone.DroneService
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import org.springframework.messaging.MessageChannel
import java.net.InetSocketAddress

class TCPChannelHandler(private val droneService: DroneService, private val integrationChannel: MessageChannel): SimpleChannelInboundHandler<ByteArray>() {
    private val parsers = mutableMapOf<Channel, Parser>()

    override fun channelActive(ctx: ChannelHandlerContext?) {
        super.channelActive(ctx)
        println("${(ctx?.channel()?.remoteAddress() as InetSocketAddress).hostString} Channel Active")
        parsers[ctx.channel()] = Parser()
    }

    override fun channelInactive(ctx: ChannelHandlerContext?) {
        super.channelInactive(ctx)
        println("${(ctx?.channel()?.remoteAddress() as InetSocketAddress).hostString} Channel Inactive, remove drone entity")
        droneService.deleteSimpleDrone(ctx.channel())
        parsers.remove(ctx.channel())
    }

    override fun channelRead0(ctx: ChannelHandlerContext, msg: ByteArray?) {
        msg ?: return

        parsers[ctx.channel()] ?.let { parser ->
            msg.forEach { byte ->
                val packet = parser.mavlink_parse_char(byte.toInt())
                if (packet != null) {
                    val message = packet.unpack()
                    val integrationMessage = MavlinkMessage(
                        channel = ctx.channel(),
                        ipAddress = (ctx.channel().remoteAddress() as InetSocketAddress).hostName,
                        port = (ctx.channel().remoteAddress() as InetSocketAddress).port,
                        droneId = droneService.getSimpleDrone(ctx.channel())!!.id,
                        message = message
                    )
                    integrationChannel.send(integrationMessage)
                }
            }
        }
    }
}