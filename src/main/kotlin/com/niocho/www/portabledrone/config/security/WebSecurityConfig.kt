package com.niocho.www.portabledrone.config.security

import com.niocho.www.portabledrone.config.security.filter.AuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.servlet.http.HttpServletResponse

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.cors()?.and()?.csrf()?.disable()
                ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ?.and()?.exceptionHandling()?.authenticationEntryPoint { _, resp, exp ->
                resp.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    exp.message
                ) }
            ?.and()
                ?.authorizeRequests()
                ?.antMatchers("/**")
                ?.permitAll()
                ?.anyRequest()
                ?.authenticated()
            ?.and()
                ?.addFilter(AuthenticationFilter(authenticationManagerBean()))
//            ?.addFilterBefore()
    }

    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource();
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}