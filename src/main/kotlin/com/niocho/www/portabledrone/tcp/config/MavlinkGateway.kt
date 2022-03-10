package com.niocho.www.portabledrone.tcp.config

import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage

interface MavlinkGateway {
    fun sendMavlinkMessage(message: MavlinkMessage)
}