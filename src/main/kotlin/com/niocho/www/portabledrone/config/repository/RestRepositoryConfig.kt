package com.niocho.www.portabledrone.config.repository

import com.niocho.www.portabledrone.common.Path
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry

@Configuration
class RestRepositoryConfig: RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration?, cors: CorsRegistry?) {
        config?.setBasePath("/${Path.REPOSITORY}")
    }
}