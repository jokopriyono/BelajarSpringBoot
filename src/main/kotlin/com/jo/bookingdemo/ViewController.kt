package com.jo.bookingdemo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@Controller
class ViewController {
    @RequestMapping("/")
    fun index(model: Model): String {
        model.addAttribute("datetime", Date())
        model.addAttribute("username", "Jokooo")
        model.addAttribute("mode", "dev")
        return "index"
    }
}