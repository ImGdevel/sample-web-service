package com.deuscodex.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(JoinController.class);
    @GetMapping("/test")
    public String getTest() {
        LOGGER.info("!!");
        return "test";
    }
}
