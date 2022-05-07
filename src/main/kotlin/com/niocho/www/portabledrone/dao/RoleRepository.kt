package com.niocho.www.portabledrone.dao

import com.niocho.www.portabledrone.common.Path
import com.niocho.www.portabledrone.dataobject.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = Path.USER, path = Path.USER)
interface RoleRepository : JpaRepository<Role, Long> {
    fun findRoleById(id: Long): Optional<Role>
}