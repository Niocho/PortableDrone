package com.niocho.www.portabledrone.engine.common

interface IDroneLogicEngineObject {
    fun getType(): String
    fun execute(context: DroneContext, config: Map<String, String>)
}