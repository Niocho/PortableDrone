package com.niocho.www.portabledrone.common.event

abstract class Event(
    var isAsync: Boolean = false
) {
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