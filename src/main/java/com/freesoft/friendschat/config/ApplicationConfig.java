package com.freesoft.friendschat.config;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.freesoft.friendschat.user.UserRepository;


@Configuration
@RequiredArgsConstructor
public class ApplicationConfig{

    private final UserRepository repository;

    @Bean
    public UserDetailsService UserDetailsService(){
        return username -> repository.findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
