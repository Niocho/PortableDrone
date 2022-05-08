package com.niocho.www.portabledrone.config.security

import com.niocho.www.portabledrone.config.security.filter.JSONAuthenticationFilter
import com.niocho.www.portabledrone.config.security.filter.JWTAuthenticationFilter
import com.niocho.www.portabledrone.config.security.provider.JSONAuthenticationProvider
import com.niocho.www.portabledrone.config.security.provider.JWTAuthenticationProvider
import com.niocho.www.portabledrone.service.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.servlet.http.HttpServletResponse

@Configuration
@EnableGlobalMethodSecurity(
    prePostEnabled = true,
    securedEnabled = true,
    jsr250Enabled = true
)
class WebSecurityConfig(
    @Autowired
    val builder: Jackson2ObjectMapperBuilder,
    @Autowired
    val userService: UserService
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http?.cors()?.and()?.csrf()?.disable()
                ?.sessionManagement()?.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            ?.and()?.exceptionHandling()?.authenticationEntryPoint { _, resp, exp ->
                resp.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    exp.message
                ) }
            ?.and()
            ?.anonymous()
            ?.and()
                ?.authorizeRequests()
                ?.antMatchers("/**")
                ?.permitAll()
                ?.anyRequest()
                ?.authenticated()
            ?.and()
            ?.authenticationProvider(JSONAuthenticationProvider(userService))
            ?.authenticationProvider(JWTAuthenticationProvider())
                ?.addFilterBefore(JWTAuthenticationFilter(authenticationManager()), AnonymousAuthenticationFilter::class.java)
                ?.addFilterBefore(JSONAuthenticationFilter(authenticationManager(), builder), JWTAuthenticationFilter::class.java)
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