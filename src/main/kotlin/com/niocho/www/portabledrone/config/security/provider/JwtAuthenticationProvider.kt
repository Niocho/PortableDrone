package com.niocho.www.portabledrone.config.security.provider

import com.niocho.www.portabledrone.config.security.token.JWTAuthentication
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication

class JwtAuthenticationProvider : AuthenticationProvider {
    override fun authenticate(authentication: Authentication?): Authentication {
        TODO("Not yet implemented")
    }

    override fun supports(authentication: Class<*>?): Boolean {
        authentication ?: return false
        return JWTAuthentication::class.java.isAssignableFrom(authentication)
    }
}