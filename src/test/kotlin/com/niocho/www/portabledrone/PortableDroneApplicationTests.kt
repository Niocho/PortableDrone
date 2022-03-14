package com.niocho.www.portabledrone

import com.niocho.www.portabledrone.service.drone.DroneService
import com.niocho.www.portabledrone.tcp.config.MavlinkGateway
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.DataOutputStream
import java.net.Socket
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

@SpringBootTest
class PortableDroneApplicationTests(
    @Autowired
    val mavlinkGateway: MavlinkGateway,
    @Autowired
    val droneService: DroneService
) {
    val logger = LoggerFactory.getLogger(PortableDroneApplicationTests::class.java)

    @Test
    fun contextLoads() {
    }

    @Test
    fun inboundMavlinkMsg() {
        fun encrypt(data: ByteArray, password: String = "1234567812345678"): ByteArray {
            val key = SecretKeySpec(password.toByteArray(Charsets.US_ASCII), "AES")
            val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            cipher.init(Cipher.ENCRYPT_MODE, key)
            return cipher.doFinal(data)
        }

        val socket = Socket("localhost", 8000)
        val outputStream = DataOutputStream(socket.getOutputStream())

        outputStream.write("1 ${Base64.getEncoder().encodeToString(encrypt(Base64.getEncoder().encode("aaabbbccc".toByteArray(Charsets.US_ASCII))))}\n".toByteArray(Charsets.US_ASCII))
        outputStream.flush()

        val msg = Base64.getEncoder().encode(com.mavlink.common.msg_attitude().pack().encodePacket())
        for (i in 1..5) {
            outputStream.write("${Base64.getEncoder().encodeToString(encrypt(msg))}\n".toByteArray(Charsets.US_ASCII))
            outputStream.flush()
        }
    }

    @Test
    fun outboundMavlinkMsg() {
        mavlinkGateway::class.java.methods.forEach {
            println(it.name)
        }
    }
}
