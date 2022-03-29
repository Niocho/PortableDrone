package com.niocho.www.portabledrone.tcp.config

import com.niocho.www.portabledrone.common.publisher.MavlinkMessageEventPublisher
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHandler

class MavlinkInboundActivator(private val mavlinkMessageEventPublisher: MavlinkMessageEventPublisher): MessageHandler {
    override fun handleMessage(message: Message<*>) {
        if (message is MavlinkMessage) {
            mavlinkMessageEventPublisher.publishEvent(message)
        }
    }
}