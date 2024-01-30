package com.deuscodex.app.controller;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/login")
public class LoginController {


    @GetMapping
    public String login(Model model) {
        model.addAttribute("message", "Hello, World!");
        return "hello"; // Thymeleaf 템플릿의 파일명 (hello.html)을 반환
    }
}
