package com.niocho.www.portabledrone.common.event.impl.server

import com.niocho.www.portabledrone.common.event.Cancellable
import com.niocho.www.portabledrone.common.event.Event
import com.niocho.www.portabledrone.common.event.HandlerList

class WebSocketEvent(
    var message: String,
    val username: String,
    source: Any,
    var cancel: Boolean = false,
) : Cancellable, Event(source) {
    companion object {
        val HANDLER_LIST = HandlerList()
    }

    override fun isCancelled(): Boolean {
        return cancel
    }

    override fun setCancelled(cancel: Boolean) {
        this.cancel = cancel
    }

    override fun getEventName(): String {
        return "WEBSOCKET_EVENT"
    }

    override fun getHandlers(): HandlerList {
        return HANDLER_LIST
    }
}