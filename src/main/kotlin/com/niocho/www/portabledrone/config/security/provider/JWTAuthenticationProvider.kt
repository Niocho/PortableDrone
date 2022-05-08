package com.niocho.www.portabledrone.config.security.provider

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.niocho.www.portabledrone.common.Constant
import com.niocho.www.portabledrone.config.security.token.JWTAuthenticationToken
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException

class JWTAuthenticationProvider : AuthenticationProvider {
    val builder = JWT.require(Algorithm.HMAC256(Constant.JWT_SECRET)).build()
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        try {
            builder.verify((authentication as JWTAuthenticationToken).credentials as String)
            authentication.isAuthenticated = true
            return authentication
        } catch (e: JWTVerificationException) {
            throw BadCredentialsException("bad credentials, invalid jwt token")
        }
    }

    override fun supports(authentication: Class<*>?): Boolean {
        authentication ?: return false
        return JWTAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}