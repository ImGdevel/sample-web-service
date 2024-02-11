package com.deuscodex.app.controller;

import com.deuscodex.app.dto.JoinDTO;
import com.deuscodex.app.service.JoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JoinController {

    @Autowired
    private JoinService joinService;
    private final Logger LOGGER = LoggerFactory.getLogger(JoinController.class);

    @GetMapping("/join")
    public String joinPage() {

        return "join";
    }


    @PostMapping("/join")
    public String joinProcess(JoinDTO joinDTO) {

        LOGGER.info(joinDTO.getUsername());
        joinService.joinProcess(joinDTO);

        return "redirect:/login";
    }
}
