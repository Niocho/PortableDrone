package com.niocho.www.portabledrone.common.publisher

import com.niocho.www.portabledrone.common.event.MavlinkMessageEvent
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component

@Component
class MavlinkMessageEventPublisher(
    @Autowired val applicationEvent: ApplicationEventPublisher
) {
    fun publishEvent(mavlinkMessage: MavlinkMessage) {
        applicationEvent.publishEvent(MavlinkMessageEvent(this, mavlinkMessage))
    }
}