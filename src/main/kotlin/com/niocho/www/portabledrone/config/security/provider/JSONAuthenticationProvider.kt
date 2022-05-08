package com.niocho.www.portabledrone.config.security.provider

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.niocho.www.portabledrone.common.Constant
import com.niocho.www.portabledrone.config.security.common.PortableDroneUser
import com.niocho.www.portabledrone.config.security.token.JSONAuthenticationToken
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import java.util.*

class JSONAuthenticationProvider(
    val userDetailsService: UserDetailsService
) : AuthenticationProvider {
    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication): Authentication {
        val dtoUser = userDetailsService.loadUserByUsername(authentication.principal as String)
        dtoUser ?: throw UsernameNotFoundException("cannot find user with given user name")
        if ((dtoUser as PortableDroneUser).authenticate(authentication.credentials as String)) {
            authentication.isAuthenticated = true
        } else {
            throw BadCredentialsException("bad credentials for user with username ${authentication.principal}")
        }
        (authentication as JSONAuthenticationToken).jwtToken = JWT.create()
                .withSubject(authentication.username)
                .withClaim("role", authentication.authorities.stream().findFirst().get().authority)
                .withExpiresAt(Date(System.currentTimeMillis() + Constant.JWT_EXPIRED_TIME))
                .sign(Algorithm.HMAC256(Constant.JWT_SECRET))
        return authentication
    }

    override fun supports(authentication: Class<*>?): Boolean {
        authentication ?: return false
        return JSONAuthenticationToken::class.java.isAssignableFrom(authentication)
    }
}