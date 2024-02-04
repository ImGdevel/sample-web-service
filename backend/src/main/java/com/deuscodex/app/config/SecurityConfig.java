package com.deuscodex.app.config;

import org.aspectj.weaver.BCException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain fitterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests((auth)-> auth
                .requestMatchers("/", "/login", "/join", "/swagger-ui/**").permitAll()
                .requestMatchers("/admin").hasRole("ADMIN")
                .requestMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().permitAll()
            )
            .formLogin((form)->form
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
            )
            .csrf(auth -> auth.disable()
            );

        return http.build();
    }

}
