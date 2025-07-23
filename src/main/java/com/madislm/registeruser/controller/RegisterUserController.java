package com.madislm.registeruser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterUserController {

    @GetMapping("/")
    public String showRegisterForm() {
        return "index";
    }
}
