package com.niocho.www.portabledrone.engine.`object`

import com.niocho.www.portabledrone.dataobject.Drone
import com.niocho.www.portabledrone.tcp.dto.MavlinkMessage

abstract class DroneContext(
    val mavlinkMessage: MavlinkMessage,
    val drone: Drone,
    val droneMetadata: MutableMap<String, String>
) {
    abstract fun executeOther(type: String, config: Map<String, String>)
}