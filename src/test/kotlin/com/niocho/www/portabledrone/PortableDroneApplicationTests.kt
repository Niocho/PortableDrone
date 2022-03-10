package com.niocho.www.portabledrone

import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import com.niocho.www.portabledrone.tcp.dto.TcpMessage
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.messaging.MessageChannel

@SpringBootTest
class PortableDroneApplicationTests(
    @Autowired(required = true)
    @Qualifier("tcpInboundChannel")
    var inbound: MessageChannel,
    @Autowired(required = true)
    @Qualifier("mavlinkOutboundChannel")
    var outbound: MessageChannel
) {

    @Test
    fun contextLoads() {
    }

    @Test
    fun channelInputTest() {
        outbound.send(MavlinkMessage(
            ipAddress = "127.0.0.1",
            port = 6379,
            droneId = 1L,
            mutableListOf(com.mavlink.common.msg_altitude())
        ))
        inbound.send(TcpMessage(
            ipAddress = "127.0.0.1",
            port = 6379,
            droneId = 1L,
            ArrayList(com.mavlink.common.msg_altitude().pack().encodePacket().asList())
        ))
    }
}
