package com.example.task23;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/")
    public String home() {
        return "register";
    }
}
