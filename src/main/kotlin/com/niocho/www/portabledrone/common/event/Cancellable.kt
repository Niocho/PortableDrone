package com.niocho.www.portabledrone.common.event

interface Cancellable {
    fun isCancelled(): Boolean
    fun setCancelled(cancel: Boolean)
}