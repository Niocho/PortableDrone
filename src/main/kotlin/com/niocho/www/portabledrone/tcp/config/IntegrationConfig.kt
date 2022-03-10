package com.niocho.www.portabledrone.tcp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.integration.annotation.ServiceActivator
import org.springframework.integration.annotation.Transformer
import org.springframework.integration.channel.DirectChannel
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.MessageHandler

@Configuration
class IntegrationConfig  {
    @Bean("mavlinkOutboundChannel")
    fun mavlinkOutboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean("tcpOutboundChannel")
    fun tcpOutboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean("mavlinkInboundChannel")
    fun mavlinkInboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean("tcpInboundChannel")
    fun tcpInboundChannel(): MessageChannel {
        return DirectChannel()
    }

    @Bean
    @Transformer(inputChannel = "tcpInboundChannel", outputChannel = "mavlinkInboundChannel")
    fun tcpToMavlinkTransformer(): org.springframework.integration.transformer.Transformer {
        return MavlinkInboundTransformer()
    }

    @Bean
    @Transformer(inputChannel = "mavlinkOutboundChannel", outputChannel = "tcpOutboundChannel")
    fun mavlinkToTcpTransformer(): org.springframework.integration.transformer.Transformer {
        return MavlinkOutboundTransformer()
    }

    @Bean("mavlinkInboundActivator")
    @ServiceActivator(inputChannel = "mavlinkInboundChannel")
    fun mavlinkActivator(): MessageHandler {
        return MavlinkActivator()
    }

    @Bean("tcpOutboundActivator")
    @ServiceActivator(inputChannel = "tcpOutboundChannel")
    fun tcpActivator(): MessageHandler {
        return TcpActivator()
    }
}