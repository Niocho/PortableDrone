package com.niocho.www.portabledrone.tcp.config

import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import com.niocho.www.portabledrone.tcp.dto.TcpMessage
import org.springframework.integration.transformer.Transformer
import org.springframework.messaging.Message

class MavlinkOutboundTransformer: Transformer {
    override fun transform(message: Message<*>?): Message<*> {
        message ?: return TcpMessage(
            ipAddress = "",
            port = -1,
            droneId = -1L,
            data = mutableListOf()
        )

        if (message is MavlinkMessage) {
            val tcpMessage = TcpMessage(
                ipAddress = message.ipAddress,
                port = message.port,
                droneId = message.droneId,
                data = mutableListOf()
            )
            val payload = message.payload
            for (msg in payload) {
                tcpMessage.data.addAll(msg.pack().encodePacket().asList())
            }
            return tcpMessage
        } else {
            return TcpMessage(
                ipAddress = "",
                port = -1,
                droneId = -1L,
                data = mutableListOf()
            )
        }
    }
}