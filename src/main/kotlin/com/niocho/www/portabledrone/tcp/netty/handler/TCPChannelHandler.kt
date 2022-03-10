package com.niocho.www.portabledrone.tcp.netty.handler

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler

class TCPChannelHandler: SimpleChannelInboundHandler<String>() {
    override fun channelActive(ctx: ChannelHandlerContext?) {
        super.channelActive(ctx)
        println("${ctx?.channel()?.remoteAddress()} Channel Active")
    }

    override fun channelInactive(ctx: ChannelHandlerContext?) {
        super.channelInactive(ctx)
        println("${ctx?.channel()?.remoteAddress()} Channel Inactive")
    }

    override fun channelRead0(ctx: ChannelHandlerContext?, msg: String?) {
        println("${ctx?.channel()?.remoteAddress()} $msg")
        ctx ?. let { channel ->
            channel.writeAndFlush("Inputted: $msg")
        }
    }
}