package com.niocho.www.portabledrone.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class HomeController {
    @GetMapping
    fun home() : Map<String, String> {
        return mapOf("name" to "Portable Drone Server Application", "version" to "0.0.1", "status" to "ready to receive connection")
    }
}