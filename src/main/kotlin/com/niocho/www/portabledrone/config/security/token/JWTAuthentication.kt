package com.niocho.www.portabledrone.config.security.token

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTVerificationException
import com.niocho.www.portabledrone.common.Constant
import com.niocho.www.portabledrone.config.security.common.PortableDroneRole
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

class JWTAuthentication(
    private val jwtToken: String,
    var usrname: String,
    var role: String,
    var authenticate: Boolean = false
) : Authentication {
    companion object {
        val verifier = JWT.require(Algorithm.HMAC256(Constant.JWT_SECRET)).build()
    }

    @Throws(JWTVerificationException::class)
    constructor(jwtToken: String) : this(jwtToken, "", "", false) {
        val decodedJWT = verifier.verify(jwtToken)
        usrname = decodedJWT.subject
        role = decodedJWT.claims["role"]?.asString() ?: throw JWTVerificationException("user $usrname role cannot be blank or null")
    }

    override fun getName(): String {
        return usrname
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableSetOf(PortableDroneRole(role))
    }

    override fun getCredentials(): Any {
        return jwtToken
    }

    override fun getDetails(): Any {
        return jwtToken
    }

    override fun getPrincipal(): Any {
        return usrname
    }

    override fun isAuthenticated(): Boolean {
        return authenticate
    }

    override fun setAuthenticated(isAuthenticated: Boolean) {
        this.authenticate = isAuthenticated
    }
}