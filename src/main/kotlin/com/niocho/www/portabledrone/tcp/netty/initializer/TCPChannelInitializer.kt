package com.niocho.www.portabledrone.tcp.netty.initializer

import com.niocho.www.portabledrone.tcp.netty.handler.TCPChannelHandler
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder

class TCPChannelInitializer: ChannelInitializer<NioSocketChannel>() {
    override fun initChannel(ch: NioSocketChannel?) {
        ch ?.let { channel ->
            channel.pipeline().addLast(StringEncoder())
            channel.pipeline().addLast(StringDecoder())
            channel.pipeline().addLast(TCPChannelHandler())
        }
    }
}