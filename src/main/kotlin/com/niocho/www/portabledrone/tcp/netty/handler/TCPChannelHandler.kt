package com.niocho.www.portabledrone.tcp.netty.handler

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import java.net.InetSocketAddress

class TCPChannelHandler: SimpleChannelInboundHandler<String>() {
    override fun channelActive(ctx: ChannelHandlerContext?) {
        super.channelActive(ctx)
        println("${(ctx?.channel()?.remoteAddress() as InetSocketAddress).hostString} Channel Active")
    }

    override fun channelInactive(ctx: ChannelHandlerContext?) {
        super.channelInactive(ctx)
        println("${(ctx?.channel()?.remoteAddress() as InetSocketAddress).hostString} Channel Inactive")
    }

    override fun channelRead0(ctx: ChannelHandlerContext?, msg: String?) {
        ctx ?.let { context ->
            context.channel().remoteAddress() ?. let {
                if (it is InetSocketAddress) {
                    println("Hostname: ${it.hostName}")
                    println("Port: ${it.port}")
                }
            }
            context.writeAndFlush("Inputted: $msg\n")
        }
    }
}