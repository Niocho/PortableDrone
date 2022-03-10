package com.niocho.www.portabledrone.tcp.config

import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler

class MavlinkActivator: MessageHandler {
    override fun handleMessage(message: Message<*>) {
        println(message.payload)
    }
}