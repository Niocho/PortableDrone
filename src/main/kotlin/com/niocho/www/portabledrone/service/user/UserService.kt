package com.niocho.www.portabledrone.service.user

import com.niocho.www.portabledrone.config.security.common.PortableDroneUser
import com.niocho.www.portabledrone.dao.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserService(
    val userDao: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userDao.findUserByName(username)
        return PortableDroneUser(
            user.get().name,
            user.get().password,
            user.get().role.name
        )
    }
}