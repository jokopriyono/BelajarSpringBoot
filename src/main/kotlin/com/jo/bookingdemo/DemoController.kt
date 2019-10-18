package com.jo.bookingdemo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @RequestMapping("/hello")
    fun hello() : String = "Hello"
}