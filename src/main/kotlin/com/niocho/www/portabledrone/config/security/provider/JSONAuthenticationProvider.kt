package com.niocho.www.portabledrone.config.security.provider

import com.niocho.www.portabledrone.config.security.token.JSONAuthentication
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException

class JSONAuthenticationProvider : AuthenticationProvider {
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication?): Authentication {
        TODO("Not yet implemented")
    }

    override fun supports(authentication: Class<*>?): Boolean {
        authentication ?: return false
        return JSONAuthentication::class.java.isAssignableFrom(authentication)
    }
}