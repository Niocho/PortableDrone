package com.niocho.www.portabledrone.tcp.config

import com.mavlink.Parser
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import com.niocho.www.portabledrone.tcp.dto.TcpMessage
import org.springframework.integration.transformer.Transformer
import org.springframework.messaging.Message

class MavlinkInboundTransformer: Transformer {
    private val parser: Parser = Parser()

    override fun transform(message: Message<*>?): Message<*> {
        message ?: return MavlinkMessage(
            ipAddress = "",
            port = -1,
            droneId = -1L,
            message = mutableListOf()
        )

        if (message is TcpMessage) {
            val mavlinkMessage = MavlinkMessage(
                ipAddress = message.ipAddress,
                port = message.port,
                droneId = message.droneId,
                message = mutableListOf()
            )
            val bytes = message.payload
            for (byte in bytes) {
                val cacheMsg = parser.mavlink_parse_char(byte.toInt())
                cacheMsg?.let {
                    mavlinkMessage.message.add(cacheMsg.unpack())
                }
            }
            return mavlinkMessage
        } else {
            return MavlinkMessage(
                ipAddress = "",
                port = -1,
                droneId = -1L,
                message = mutableListOf()
            )
        }
    }
}