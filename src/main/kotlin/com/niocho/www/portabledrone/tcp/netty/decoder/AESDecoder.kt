package com.niocho.www.portabledrone.tcp.netty.decoder

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder

class AESDecoder: MessageToMessageDecoder<String>() {
    override fun decode(ctx: ChannelHandlerContext?, msg: String?, out: MutableList<Any>?) {
        TODO("Not yet implemented")
    }
}