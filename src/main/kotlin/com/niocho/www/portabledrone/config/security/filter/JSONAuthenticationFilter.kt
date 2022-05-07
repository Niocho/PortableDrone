package com.niocho.www.portabledrone.config.security.filter

import org.springframework.security.authentication.AuthenticationManager
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class JSONAuthenticationFilter(
    val authenticationManager: AuthenticationManager
) : Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        chain.doFilter(request, response)
    }
}