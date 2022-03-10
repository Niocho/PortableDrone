package com.niocho.www.portabledrone.tcp.dto

import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders

class TcpMessage(
    val ipAddress: String,
    val port: Int,
    val droneId: Long,
    val data: MutableList<Byte>
) : Message<MutableList<Byte>> {
    override fun getPayload(): MutableList<Byte> {
        return this.data
    }

    override fun getHeaders(): MessageHeaders {
        return MessageHeaders(
            mutableMapOf <String, Any> (
                "ipAddress" to this.ipAddress,
                "port" to this.port,
                "droneId" to this.droneId
            )
        )
    }
}