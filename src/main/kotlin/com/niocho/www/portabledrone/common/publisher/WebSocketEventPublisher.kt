package com.niocho.www.portabledrone.common.publisher

import com.niocho.www.portabledrone.common.event.impl.server.WebSocketEvent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class WebSocketEventPublisher(
    @Autowired val applicationEvent: ApplicationEventPublisher
) {
    fun publishEvent(username: String, message: String, source: Any) {
        applicationEvent.publishEvent(WebSocketEvent(username, message, source))
    }
}