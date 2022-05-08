package com.niocho.www.portabledrone.config.websocket

import com.niocho.www.portabledrone.common.publisher.WebSocketEventPublisher
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import javax.naming.AuthenticationException
import javax.websocket.OnClose
import javax.websocket.OnError
import javax.websocket.OnMessage
import javax.websocket.OnOpen
import javax.websocket.Session
import javax.websocket.server.PathParam
import javax.websocket.server.ServerEndpoint

@Component
@Slf4j
@ServerEndpoint("/websocket/{username}/{password}")
class WebSocketServer(
    @Autowired
    val authenticationManager: AuthenticationManager,
    @Autowired
    val webSocketEventPublisher: WebSocketEventPublisher
) {
    companion object {
        val onlineCount: AtomicLong = AtomicLong()
        val sessionMap: MutableMap<String, WebSocketServer> = ConcurrentHashMap()
        val logger: Logger = LoggerFactory.getLogger(WebSocketServer::class.java)
        fun sendInfo(message: String, username: String) {
            sessionMap[username]?.sendMessage(message) ?: run {
                logger.warn("user $username is offline")
            }
        }
    }

    var session: Session? = null
    var username: String? = null

    @OnOpen
    fun onOpen(session: Session, @PathParam("username") username: String, @PathParam("password") password: String) {
        try {
            SecurityContextHolder.getContext().authentication = authenticationManager.authenticate(UsernamePasswordAuthenticationToken(
                username,
                password
            ))
        } catch (e: AuthenticationException) {
            logger.info("user $username disconnected: ${e.message}")
            session.close()
            return
        }
        this.session = session
        this.username = username
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username)
            sessionMap[username] = this
        } else {
            sessionMap[username] = this
            onlineCount.incrementAndGet()
        }
        logger.info("user $username connected, online sessions: ${onlineCount.get()}")
    }

    @OnClose
    fun onClose() {
        if (sessionMap.containsKey(username)) {
            sessionMap.remove(username)
            onlineCount.decrementAndGet()
        }
        logger.info("user $username disconnected, online sessions: ${onlineCount.get()}")
    }

    @OnMessage
    fun onMessage(message: String, session: Session) {
        webSocketEventPublisher.publishEvent(username!!, message, this)
    }

    @OnError
    fun onError(session: Session, error: Throwable) {
        logger.warn("user $username exception: ${error.message}")
    }

    fun sendMessage(message: String) {
        try {
            session?.basicRemote?.sendText(message)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}