package com.niocho.www.portabledrone.config.security.provider

import com.niocho.www.portabledrone.config.security.token.JWTAuthentication
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException

class JWTAuthenticationProvider : AuthenticationProvider {
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication?): Authentication {
        TODO("Not yet implemented")
    }

    override fun supports(authentication: Class<*>?): Boolean {
        authentication ?: return false
        return JWTAuthentication::class.java.isAssignableFrom(authentication)
    }
}