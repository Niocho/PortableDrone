package com.niocho.www.portabledrone.tcp.netty

import com.niocho.www.portabledrone.service.drone.DroneService
import com.niocho.www.portabledrone.tcp.netty.initializer.TCPChannelInitializer
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.MessageChannel
import javax.annotation.PreDestroy

@Configuration
class NettyConfig(@Autowired val droneService: DroneService, @Autowired @Qualifier("mavlinkInboundChannel") val messageChannel: MessageChannel) {
    var future: ChannelFuture? = null
    val bossGroup = NioEventLoopGroup()
    val workerGroup = NioEventLoopGroup()

    @Bean
    fun getNettyServer(): ServerBootstrap {

        val bootstrap = ServerBootstrap()
        bootstrap.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel::class.java)
            .childHandler(TCPChannelInitializer(droneService, messageChannel))
            .option(ChannelOption.SO_BACKLOG, 1024)
            .childOption(ChannelOption.SO_KEEPALIVE, true)
            .childOption(ChannelOption.TCP_NODELAY, true)
        future = bootstrap.bind(8000)
        return bootstrap
    }

    @PreDestroy
    fun onQuit() {
        bossGroup.shutdownGracefully()
        workerGroup.shutdownGracefully()
        future?.channel()?.close()
    }
}