package com.niocho.www.portabledrone.service.drone

import com.niocho.www.portabledrone.dao.DroneMetadataRepository
import com.niocho.www.portabledrone.dao.DroneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DroneService (
    @Autowired
    val droneRepository: DroneRepository,
    val droneMetadataRepository: DroneMetadataRepository
    ){
    class Result (
        val droneId: Long,
        val aesPassword: String
    )

    @Transactional
    fun authenticateDroneWithIdAndPassword(droneId: Long, aesPassword: String) : Result? {
        val opt = droneRepository.findDroneById(droneId)
        if (opt.isPresent) {
            val drone = opt.get()
            val metadatas = droneMetadataRepository.findDroneMetadataByBelongTo(drone)
            metadatas.forEach { metadata ->
                if (metadata.key == com.niocho.www.portabledrone.dataobject.Metadata.AES_PASSWORD && metadata.value == aesPassword) {
                    return Result(droneId, aesPassword)
                } else {
                    return@forEach
                }
            }
            return null
        }
        return null
    }
}