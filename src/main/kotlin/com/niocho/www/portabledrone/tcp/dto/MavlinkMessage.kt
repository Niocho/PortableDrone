package com.niocho.www.portabledrone.tcp.dto

import com.mavlink.Messages.MAVLinkMessage
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders

class MavlinkMessage(
    val ipAddress: String,
    val port: Int,
    val droneId: Long,
    var message: MutableList<MAVLinkMessage>
) : Message<MutableList<MAVLinkMessage>> {
    override fun getPayload(): MutableList<MAVLinkMessage> {
        return this.message
    }

    override fun getHeaders(): MessageHeaders {
        return MessageHeaders(
            mutableMapOf<String, Any>(
                "ipAddress" to this.ipAddress,
                "port" to this.port,
                "droneId" to this.droneId
            )
        )
    }
}