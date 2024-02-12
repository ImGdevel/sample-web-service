package com.deuscodex.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(JoinController.class);
    @GetMapping("/test")
    public String getTest() {
        LOGGER.info("!!");
        return "Test";
    }
}
