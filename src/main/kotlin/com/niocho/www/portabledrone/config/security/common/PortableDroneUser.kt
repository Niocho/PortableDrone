package com.niocho.www.portabledrone.config.security.common

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class PortableDroneUser(
    private val usrname: String,
    private val encryptedPassword: String,
    private val role : String
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableSetOf(PortableDroneRole(role))
    }

    override fun getPassword(): String {
        return encryptedPassword
    }

    override fun getUsername(): String {
        return usrname
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun authenticate(password: String) : Boolean {
        return BCryptPasswordEncoder().matches(password, encryptedPassword)
    }
}