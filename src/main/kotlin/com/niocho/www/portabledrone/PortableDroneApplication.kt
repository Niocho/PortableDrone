package com.niocho.www.portabledrone

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PortableDroneApplication

fun main(args: Array<String>) {
    runApplication<PortableDroneApplication>(*args)
}
