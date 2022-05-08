package com.niocho.www.portabledrone.config.security.filter

import com.auth0.jwt.exceptions.JWTVerificationException
import com.niocho.www.portabledrone.config.security.token.JWTAuthenticationToken
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTAuthenticationFilter(
    private val authenticationManager: AuthenticationManager
) : Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        if (request !is HttpServletRequest) {
            chain.doFilter(request, response)
            return
        }
        val authenticationStr = request.getHeader("Authentication")?.replace("Bearer ", "")
        authenticationStr ?: run {
            chain.doFilter(request, response)
            return
        }

        try {
            var authentication = JWTAuthenticationToken(authenticationStr)
            authentication = authenticationManager.authenticate(authentication) as JWTAuthenticationToken
            SecurityContextHolder.getContext().authentication = authentication
            if (authentication.shouldUpdate()) {
                (response as HttpServletResponse).setHeader("Authentication", authentication.flushJWTToken())
                chain.doFilter(request, response)
                return
            }
        } catch (e: JWTVerificationException) {
            (response as HttpServletResponse).status = HttpStatus.UNAUTHORIZED.value()
            response.writer.close()
            return
        } catch (e: AuthenticationException) {
            (response as HttpServletResponse).status = HttpStatus.UNAUTHORIZED.value()
            response.writer.close()
            return
        }
    }
}