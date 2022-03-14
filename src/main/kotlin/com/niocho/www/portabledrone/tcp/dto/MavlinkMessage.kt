package com.niocho.www.portabledrone.tcp.dto

import com.mavlink.Messages.MAVLinkMessage
import io.netty.channel.Channel
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders
import java.net.InetSocketAddress

class MavlinkMessage(
    val channel: Channel,
    val ipAddress: String = (channel.remoteAddress() as InetSocketAddress).hostName,
    val port: Int = (channel.remoteAddress() as InetSocketAddress).port,
    val droneId: Long,
    var message: MAVLinkMessage
) : Message<MAVLinkMessage> {
    override fun getPayload(): MAVLinkMessage {
        return this.message
    }

    override fun getHeaders(): MessageHeaders {
        return MessageHeaders(
            mutableMapOf<String, Any>(
                "channel" to this.channel,
                "ipAddress" to this.ipAddress,
                "port" to this.port,
                "droneId" to this.droneId
            )
        )
    }
}