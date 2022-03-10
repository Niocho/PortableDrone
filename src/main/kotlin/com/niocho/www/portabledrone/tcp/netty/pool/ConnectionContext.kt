package com.niocho.www.portabledrone.tcp.netty.pool

import io.netty.channel.Channel

object ConnectionContext {
    val keyMap: MutableMap<Channel, String> = mutableMapOf()
    val messageCache: MutableMap<Channel, String> = mutableMapOf()
}