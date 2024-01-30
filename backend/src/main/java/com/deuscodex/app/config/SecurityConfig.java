package com.deuscodex.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain fitterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((auth)-> auth
                .requestMatchers("/", "/login", "/join").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().denyAll()
        );

        http.formLogin((auth)->auth
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
        );

        http.csrf(auth -> auth.disable());

        return http.build();
    }

}
