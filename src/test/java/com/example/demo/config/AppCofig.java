package com.example.demo.config;

import com.example.demo.json.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCofig {

    @Bean
    public Greeting defaultGreeting(){
        return new Greeting("Hello, World!");
    }

}
