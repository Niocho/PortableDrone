package com.niocho.www.portabledrone.common.event

import com.niocho.www.portabledrone.plugin.PortableDronePlugin
import org.springframework.context.ApplicationListener

class HandlerList {
    fun bake() {

    }
    companion object {
        fun bakeAll() {

        }
        fun getHandlerLists(): ArrayList<HandlerList> {
            return arrayListOf()
        }
        fun getRegisteredListeners(): Array<RegisteredListener> {
            return arrayOf()
        }
        fun unregisterAll() {

        }
        fun unregisterAll(listener: ApplicationListener<*>) {

        }
        fun unregisterAll(plugin: PortableDronePlugin) {

        }
    }

    fun register(listener: RegisteredListener) {

    }

    fun registerAll(listeners: Collection<RegisteredListener>) {

    }

    fun unregister(listener: RegisteredListener) {

    }

    fun unregister(plugin: PortableDronePlugin) {

    }

    fun unregister(listener: ApplicationListener<*>) {

    }
}