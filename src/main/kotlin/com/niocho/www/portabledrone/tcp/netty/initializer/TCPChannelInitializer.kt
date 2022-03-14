package com.niocho.www.portabledrone.tcp.netty.initializer

import com.niocho.www.portabledrone.service.drone.DroneService
import com.niocho.www.portabledrone.tcp.netty.decoder.AESDecoder
import com.niocho.www.portabledrone.tcp.netty.encoder.AESEncoder
import com.niocho.www.portabledrone.tcp.netty.handler.TCPChannelHandler
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.DelimiterBasedFrameDecoder
import io.netty.handler.codec.Delimiters
import io.netty.handler.codec.string.StringDecoder
import org.springframework.messaging.MessageChannel

class TCPChannelInitializer(private val droneService: DroneService, private val messageChannel: MessageChannel): ChannelInitializer<NioSocketChannel>() {
    override fun initChannel(ch: NioSocketChannel?) {
        /**
         * data stream:
         *              mavlink packet -> byte stream -> aes256 / none -> base64(string) -> line delimiter -> base64(string) -> aes256 / none -> byte stream -> mavlink packet
         */
        ch ?.let { channel ->
            channel.pipeline().addLast(AESEncoder())
            channel.pipeline().addLast(StringDecoder(), DelimiterBasedFrameDecoder(8192, * Delimiters.lineDelimiter()), AESDecoder(droneService))
            channel.pipeline().addLast(TCPChannelHandler(droneService, messageChannel))
        }
    }
}