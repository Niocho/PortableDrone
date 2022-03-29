package com.niocho.www.portabledrone.tcp.dto

import com.mavlink.Messages.MAVLinkMessage
import io.netty.channel.Channel
import org.springframework.messaging.Message
import org.springframework.messaging.MessageHeaders
import java.net.InetSocketAddress

class MavlinkMessage(
    val channel: Channel,
    val address: String = if (channel.remoteAddress() is InetSocketAddress) { (channel.remoteAddress() as InetSocketAddress).hostName } else { channel.remoteAddress().toString() },
    val port: Int = if (channel.remoteAddress() is InetSocketAddress) { (channel.remoteAddress() as InetSocketAddress).port } else { -1 },
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
                "address" to this.address,
                "port" to this.port,
                "droneId" to this.droneId
            )
        )
    }
}