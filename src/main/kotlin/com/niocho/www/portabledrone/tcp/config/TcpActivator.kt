package com.niocho.www.portabledrone.tcp.config

import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler

class TcpActivator: MessageHandler {
    override fun handleMessage(message: Message<*>) {
        println("发送 datapack")
        println(message.payload)
    }
}