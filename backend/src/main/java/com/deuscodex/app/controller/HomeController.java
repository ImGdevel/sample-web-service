package com.deuscodex.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class HomeController {

    private final Logger LOGGER = LoggerFactory.getLogger(JoinController.class);

    @GetMapping("/")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        LOGGER.info(authentication.toString());

        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            String id = authentication.getName();
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            Iterator<? extends GrantedAuthority> iter = authorities.iterator();
            GrantedAuthority auth = iter.next();
            String role = auth.getAuthority();

            model.addAttribute("id", id);
            model.addAttribute("role", role);
            model.addAttribute("loggedIn", true);
        }else{
            model.addAttribute("loggedIn", false);
        }


        return "home";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Admin";
    }
}
