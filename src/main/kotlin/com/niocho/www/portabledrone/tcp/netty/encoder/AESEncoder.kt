package com.niocho.www.portabledrone.tcp.netty.encoder

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder

class AESEncoder: MessageToMessageEncoder<String>() {
    override fun encode(ctx: ChannelHandlerContext?, msg: String?, out: MutableList<Any>?) {
        TODO("Not yet implemented")
    }
}