package com.niocho.www.portabledrone.common.event.impl

import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.springframework.context.ApplicationEvent

class MavlinkMessageEvent(source: Any, val message: MavlinkMessage) : ApplicationEvent(source)