package com.niocho.www.portabledrone.controller.drone

import com.niocho.www.portabledrone.common.Path
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
class DroneController {
    @RequestMapping("/${Path.DRONE}/test", method = [ RequestMethod.GET ])
    @ResponseBody
    fun test(): Map<String, String>{
        return mapOf("drone" to "Hello, world!")
    }

    @RequestMapping("/${Path.DRONE_METADATA}/test", method = [ RequestMethod.GET ])
    @ResponseBody
    fun testMeta(): Map<String, String>{
        return mapOf("metadata" to "Hello, world!")
    }
}