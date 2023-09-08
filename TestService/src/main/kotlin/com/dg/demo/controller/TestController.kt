package com.dg.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test22")
    fun test(): String{
        return "Test Get"
    }
}