package com.niocho.www.portabledrone.dao

import com.niocho.www.portabledrone.common.Path
import com.niocho.www.portabledrone.dataobject.Drone
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = Path.DRONE, path = Path.DRONE)
interface DroneRepository : JpaRepository<Drone, Long>{
    fun findDroneById(id: Long): Optional<Drone>
    fun findDroneByName(name: String): Optional<Drone>
    @RestResource(exported = false)
    override fun delete(entity: Drone)
    @RestResource(exported = false)
    override fun deleteById(id: Long)
}