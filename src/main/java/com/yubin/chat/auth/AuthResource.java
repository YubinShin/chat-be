package com.yubin.chat.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthResource {
    @GetMapping("/auth/login")
    public String login(){
        return "login";
    }
}
