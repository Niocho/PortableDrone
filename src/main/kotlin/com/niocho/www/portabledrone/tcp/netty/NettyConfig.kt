package com.niocho.www.portabledrone.tcp.netty

import com.niocho.www.portabledrone.tcp.netty.initializer.TCPChannelInitializer
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.annotation.PreDestroy

@Configuration
class NettyConfig {
    var future: ChannelFuture? = null
    val bossGroup = NioEventLoopGroup()
    val workerGroup = NioEventLoopGroup()

    @Bean
    fun getNettyServer(): ServerBootstrap {

        val bootstrap = ServerBootstrap()
        bootstrap.group(bossGroup, workerGroup)
            .channel(NioServerSocketChannel::class.java)
            .childHandler(TCPChannelInitializer())
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