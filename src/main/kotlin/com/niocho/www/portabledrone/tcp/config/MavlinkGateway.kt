package com.niocho.www.portabledrone.tcp.config

import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.springframework.integration.annotation.Gateway
import org.springframework.integration.annotation.MessagingGateway

@MessagingGateway(
    name = "mavlinkGateway"
)
interface MavlinkGateway {
    @Gateway(requestChannel = "mavlinkOutboundChannel")
    fun sendMavlinkMessage(message: MavlinkMessage)
}