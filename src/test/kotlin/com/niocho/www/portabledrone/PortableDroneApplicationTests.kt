package com.niocho.www.portabledrone

import com.niocho.www.portabledrone.tcp.config.MavlinkGateway
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PortableDroneApplicationTests(
    @Autowired
    val mavlinkGateway: MavlinkGateway
) {
    @Test
    fun contextLoads() {
    }

    @Test
    fun inboundMavlinkMsg() {

    }

    @Test
    fun outboundMavlinkMsg() {
        mavlinkGateway::class.java.methods.forEach {
            println(it.name)
        }
    }
}
