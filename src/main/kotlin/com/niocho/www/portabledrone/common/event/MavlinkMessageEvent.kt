package com.niocho.www.portabledrone.common.event

import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage
import org.springframework.context.ApplicationEvent

class MavlinkMessageEvent(source: Any, val message: MavlinkMessage) : ApplicationEvent(source)