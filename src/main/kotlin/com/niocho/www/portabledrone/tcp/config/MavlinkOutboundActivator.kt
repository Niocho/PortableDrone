package com.niocho.www.portabledrone.tcp.config

import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler

class MavlinkOutboundActivator : MessageHandler {
    override fun handleMessage(message: Message<*>) {
        if (message is MavlinkMessage) {
            message.channel.write(message.message.pack().encodePacket())
        } else {
            throw RuntimeException("given message is not mavlink message")
        }
    }
}