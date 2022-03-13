package com.niocho.www.portabledrone.dao

import com.niocho.www.portabledrone.common.Path
import com.niocho.www.portabledrone.dataobject.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = Path.USER, path = Path.USER)
interface UserRepository : JpaRepository<User, Long> {
    fun findUserById(id: Int): Optional<User>
    fun findUserByName(name: String): Optional<User>
}