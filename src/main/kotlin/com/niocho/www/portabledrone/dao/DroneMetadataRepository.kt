package com.niocho.www.portabledrone.dao

import com.niocho.www.portabledrone.common.Path
import com.niocho.www.portabledrone.dataobject.Drone
import com.niocho.www.portabledrone.dataobject.DroneMetadata
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import java.util.Optional

@RepositoryRestResource(collectionResourceRel = Path.DRONE_METADATA, path = Path.DRONE_METADATA)
interface DroneMetadataRepository : JpaRepository<DroneMetadata, Int> {
    fun findDroneMetadataById(id: Int): Optional<DroneMetadata>
    fun findDroneMetadataByKey(key: String): Optional<DroneMetadata>
    fun findDroneMetadataByValue(value: String): Optional<DroneMetadata>
    fun findDroneMetadataByBelongTo(drone: Drone): List<DroneMetadata>
    @RestResource(exported = false)
    override fun delete(entity: DroneMetadata)
    @RestResource(exported = false)
    override fun deleteById(id: Int)
}