package com.niocho.www.portabledrone.tcp.netty.decoder

import com.niocho.www.portabledrone.service.drone.DroneService
import com.niocho.www.portabledrone.tcp.netty.pool.ConnectionContext
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder

class AESDecoder(droneService: DroneService): MessageToMessageDecoder<String>() {
    override fun decode(ctx: ChannelHandlerContext, msg: String?, out: MutableList<Any>?) {
        msg ?: run {
            ctx.channel().close()
        }
        ConnectionContext.keyMap[ctx.channel()] ?: run {
            // 认证消息结构: [无人机ID AES加密的时间戳]
        }
    }
}