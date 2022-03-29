package com.niocho.www.portabledrone.engine.listener

import com.niocho.www.portabledrone.common.event.MavlinkMessageEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class MavlinkMessageEventListener : ApplicationListener<MavlinkMessageEvent> {
    override fun onApplicationEvent(event: MavlinkMessageEvent) {
        when (event.message.message) {

        }
    }
}