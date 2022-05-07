package com.niocho.www.portabledrone.common.event

annotation class EventHandler(
    val ignoreCancelled: Boolean = false,
    val priority: Event.EventPriority = Event.EventPriority.NORMAL
)
