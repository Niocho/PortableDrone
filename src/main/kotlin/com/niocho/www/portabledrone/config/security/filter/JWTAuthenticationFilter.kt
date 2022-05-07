package com.niocho.www.portabledrone.config.security.filter

import org.springframework.security.authentication.AuthenticationManager
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class JWTAuthenticationFilter(
    val authenticationManager: AuthenticationManager
) : Filter {
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        TODO("Not yet implemented")
    }
}