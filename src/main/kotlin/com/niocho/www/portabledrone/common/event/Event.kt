package com.niocho.www.portabledrone.common.event

import org.springframework.context.ApplicationEvent

abstract class Event(
    source: Any,
    var isAsync: Boolean = false
) : ApplicationEvent(source) {
    abstract fun getEventName(): String
    abstract fun getHandlers(): HandlerList
    fun isAsynchronous(): Boolean {
        return isAsync
    }

    enum class Result {
        ALLOW,
        DEFAULT,
        DENY
    }

    enum class EventPriority {
        HIGH,
        HIGHEST,
        LOW,
        LOWEST,
        MONITOR,
        NORMAL
    }
}