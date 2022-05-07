package com.niocho.www.portabledrone.config.security.common

import org.springframework.security.core.GrantedAuthority

class PortableDroneRole(
    private val role: String
) : GrantedAuthority {
    override fun getAuthority(): String {
        return role
    }
}