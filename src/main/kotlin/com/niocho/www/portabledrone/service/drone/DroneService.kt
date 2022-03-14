package com.niocho.www.portabledrone.service.drone

import com.mavlink.Messages.MAVLinkMessage
import com.niocho.www.portabledrone.dao.DroneMetadataRepository
import com.niocho.www.portabledrone.dao.DroneRepository
import com.niocho.www.portabledrone.tcp.config.MavlinkGateway
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import io.netty.channel.Channel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Service
class DroneService (
    @Autowired
    val droneRepository: DroneRepository,
    @Autowired
    val droneMetadataRepository: DroneMetadataRepository,
    @Autowired
    val mavlinkGateway: MavlinkGateway
    ){

    /**
     * 用于连接的缓存在内存中的无人机实体对象
     */
    val droneCache: MutableMap<Channel, SimpleDrone> = mutableMapOf()

    /**
     * 负责 AES 算法的加解密
     */
    companion object AES {
        private const val KEY_ALGORITHM = "AES"
        private const val CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"
        private val keyCache: MutableMap<String, SecretKey> = mutableMapOf()

        /**
         * 根据给出的密码加密数据，对于重复密钥将进行缓存以加快效率
         */
        @Throws(Exception::class)
        fun encrypt(data: ByteArray, password: String): ByteArray {
            keyCache[password] ?: run {
                keyCache[password] = SecretKeySpec(password.toByteArray(Charsets.US_ASCII), KEY_ALGORITHM)
            }
            val cipher: Cipher = Cipher.getInstance(CIPHER_ALGORITHM)
            cipher.init(Cipher.ENCRYPT_MODE, keyCache[password])
            return cipher.doFinal(data)
        }

        /**
         * 根据给出的密码解密数据，对于重复密钥将进行缓存以加快效率
         */
        @Throws(Exception::class)
        fun decrypt(data: ByteArray, password: String): ByteArray {
            keyCache[password] ?: run {
                keyCache[password] = SecretKeySpec(password.toByteArray(Charsets.US_ASCII), KEY_ALGORITHM)
            }
            val cipher: Cipher = Cipher.getInstance(CIPHER_ALGORITHM)
            cipher.init(Cipher.DECRYPT_MODE, keyCache[password])
            return cipher.doFinal(data)
        }
    }

    /**
     * 内存无人机实体对象
     */
    class SimpleDrone(
        var id: Long,
        var name: String,
        var password: String?,
        var metadata: MutableMap<String, String>
    )

    fun exists(channel: Channel): Boolean {
        return droneCache[channel] != null
    }

    fun getSimpleDrone(channel: Channel): SimpleDrone? {
        return droneCache[channel]
    }

    fun deleteSimpleDrone(channel: Channel) {
        droneCache.remove(channel)
    }

    fun send(droneId: Long, message: MAVLinkMessage) {
        droneCache.forEach { drone ->
            if (drone.value.id == droneId) {
                val msg = MavlinkMessage(drone.key, droneId = droneId, message = message)
                mavlinkGateway.sendMavlinkMessage(msg)
            }
        }
    }
    /**
     * 无人机认证算法，如果无人机的 metadata 中给出了 AES_PASSWORD 项，就会进行认证，反之会直接通过无人机连接请求
     */
    @Throws(BadCredentialsException::class, UsernameNotFoundException::class)
    @Transactional
    fun authenticateDroneWithId(channel: Channel, droneId: Long, testMsg: ByteArray) {
        val opt = droneRepository.findDroneById(droneId)
        if (opt.isEmpty) {
            throw UsernameNotFoundException("cannot find drone with given drone id: $droneId")
        }

        val drone = opt.get()
        val simpleDrone = SimpleDrone(
            droneId,
            drone.name,
            null,
            mutableMapOf()
        )
        val metadatas = droneMetadataRepository.findDroneMetadataByBelongTo(drone)
        metadatas.forEach { metadata ->
            if (metadata.key == com.niocho.www.portabledrone.dataobject.Metadata.AES_PASSWORD) {
                try {
                    decrypt(testMsg, metadata.value)
                    simpleDrone.password = metadata.value
                    droneCache[channel] = simpleDrone
                } catch (e: Exception) {
                    throw BadCredentialsException("bad credential when authenticate $droneId")
                }
            } else {
                simpleDrone.metadata[metadata.key] = metadata.value
            }
        }
        droneCache[channel] = simpleDrone
    }

    /**
     * 无人机数据解密算法，在找到无人机内存实体对象后会进行解密，如果没有密码则直接返回数据，如果有密码则解密后返回数据，可能会抛出异常
     */
    @Throws(BadCredentialsException::class, Exception::class)
    @Transactional
    fun decrypt(channel: Channel, data: ByteArray): ByteArray {
        val simpleDrone = droneCache[channel] ?: throw BadCredentialsException("cannot find channel ${channel.remoteAddress()}'s simple drone entity")
        simpleDrone.password ?. let {
            return AES.decrypt(data, simpleDrone.password!!)
        } ?: run {
            return data
        }
    }

    /**
     * 无人机数据加密算法，在找到无人机内存实体对象后会进行加密，如果没有密码则直接返回数据，如果有密码则加密后返回数据，可能会抛出异常
     */
    @Throws(BadCredentialsException::class, Exception::class)
    @Transactional
    fun encrypt(channel: Channel ,data: ByteArray): ByteArray {
        val simpleDrone = droneCache[channel] ?: throw BadCredentialsException("cannot find channel ${channel.remoteAddress()}'s simple drone entity")
        simpleDrone.password ?. let {
            return AES.encrypt(data, simpleDrone.password!!)
        } ?: run {
            return data
        }
    }
}