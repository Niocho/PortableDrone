package com.niocho.www.portabledrone.engine.listener

import com.niocho.www.portabledrone.common.event.impl.MavlinkMessageEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class MavlinkMessageEventListener : ApplicationListener<MavlinkMessageEvent> {
    override fun onApplicationEvent(event: MavlinkMessageEvent) {
        when (event.message.message) {

        }
    }
}