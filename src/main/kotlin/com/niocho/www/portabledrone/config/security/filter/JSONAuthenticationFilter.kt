package com.niocho.www.portabledrone.config.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.niocho.www.portabledrone.common.Path
import com.niocho.www.portabledrone.config.security.token.JSONAuthentication
import org.springframework.http.HttpStatus
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JSONLoginRequest (
    val username: String,
    val password: String
)

class JSONAuthenticationFilter(
    private val authenticationManager: AuthenticationManager,
    private val jacksonBuilder: Jackson2ObjectMapperBuilder,
    private val objectMapper: ObjectMapper = jacksonBuilder.build()
) : Filter {
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        if (request !is HttpServletRequest) {
            throw RuntimeException("request is not http request")
        }
        if (request.requestURI.toString().startsWith("/${Path.USER}/login") || request.requestURI.toString().startsWith("${Path.USER}/login")) {
            if (request.method == "POST") {
                try {
                    val body = request.reader.readLines().joinToString(separator = "\n") {
                        it
                    }
                    val result = objectMapper.readValue(body, JSONLoginRequest::class.java)
                    val authentication = authenticationManager.authenticate(JSONAuthentication(
                        username = result.username,
                        password = result.password
                    ))
                    SecurityContextHolder.getContext().authentication = authentication
                    (response as HttpServletResponse).status = HttpStatus.OK.value()
                    response.addHeader("Authentication", (authentication as JSONAuthentication).jwtToken)
                    response.writer.close()
                } catch (e: AuthenticationException) {
                    (response as HttpServletResponse).status = HttpStatus.FORBIDDEN.value()
                    response.writer.close()
                }
                catch (e: Exception) {
                    (response as HttpServletResponse).status = HttpStatus.BAD_REQUEST.value()
                    response.writer.close()
                }
            } else {
                (response as HttpServletResponse).status = HttpStatus.METHOD_NOT_ALLOWED.value()
                response.writer.close()
            }
        } else {
            chain.doFilter(request, response)
        }
    }
}