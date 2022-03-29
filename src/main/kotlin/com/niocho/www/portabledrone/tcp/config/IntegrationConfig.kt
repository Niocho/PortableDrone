package com.niocho.www.portabledrone.tcp.config

import com.niocho.www.portabledrone.common.publisher.MavlinkMessageEventPublisher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler

@Configuration
class IntegrationConfig(@Autowired val mavlinkMessageEventPublisher: MavlinkMessageEventPublisher) {
    @Bean("mavlinkOutboundChannel")
    fun mavlinkOutboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean("mavlinkInboundChannel")
    fun mavlinkInboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean("mavlinkInboundActivator")
    @ServiceActivator(inputChannel = "mavlinkInboundChannel")
    fun mavlinkInboundActivator(): MessageHandler {
        return MavlinkInboundActivator(mavlinkMessageEventPublisher)
    }

    @Bean("mavlinkOutboundActivator")
    @ServiceActivator(inputChannel = "mavlinkOutboundChannel")
    fun mavlinkOutboundActivator(): MessageHandler {
        return MavlinkOutboundActivator()
    }
}