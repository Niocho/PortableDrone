package com.niocho.www.portabledrone.config.security.token

import com.niocho.www.portabledrone.config.security.common.PortableDroneRole
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

class JSONAuthentication(
    val username: String,
    var password: String,
    val jwtToken: String = "",
    val authorities: MutableSet<PortableDroneRole> = mutableSetOf(),
    var authenticate: Boolean = false,
) : Authentication {
    override fun getName(): String {
        return username
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return authorities
    }

    override fun getCredentials(): Any {
        return password
    }

    override fun getDetails(): Any {
        return username
    }

    override fun getPrincipal(): Any {
        return username
    }

    override fun isAuthenticated(): Boolean {
        return authenticate
    }

    override fun setAuthenticated(isAuthenticated: Boolean) {
        this.authenticate = isAuthenticated
    }
}