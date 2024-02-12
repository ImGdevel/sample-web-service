package com.deuscodex.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/login/oauth2/code/{provider}")
    public String loginOauth2Code(@PathVariable String provider) {
        return "redirect:/";
    }

}
