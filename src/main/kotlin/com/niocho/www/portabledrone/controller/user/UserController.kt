package com.niocho.www.portabledrone.controller.user

import com.niocho.www.portabledrone.common.Path
import org.springframework.data.rest.webmvc.RepositoryRestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@RepositoryRestController
class UserController {
    @RequestMapping("/${Path.USER}/test", method = [ RequestMethod.GET ])
    @ResponseBody
    fun test(): Map<String, String> {
        return mapOf("user" to "Hello, world!")
    }
}