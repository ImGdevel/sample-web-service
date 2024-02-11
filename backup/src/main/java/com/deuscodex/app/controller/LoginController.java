package com.deuscodex.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")

@Controller
@RequestMapping("/login")
public class LoginController {

    private final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @GetMapping
    public String loginForm() {
        LOGGER.info("Login From Call");
        return "login";
    }

    @PostMapping
    public String processLoginForm(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        // 여기에서 받은 데이터를 이용하여 로그인 처리 또는 필요한 작업 수행
        // ...
        LOGGER.info("FROM");
        LOGGER.info("username = {} password = {}" ,username, password);
        // 예제: 받은 데이터를 모델에 추가하여 Thymeleaf에서 사용할 수 있도록 함
        model.addAttribute("username", username);
        model.addAttribute("password", password);

        // 처리 후 적절한 뷰로 이동
        return "redirect:/login";
    }
}
