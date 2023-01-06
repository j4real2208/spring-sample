package com.example.demo.controllers;

import com.example.demo.json.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerTest {

    @Test
    @Description("Test where we provide the name param")
    public void greetWithName(@Autowired TestRestTemplate template){
        Greeting response = template.getForObject("/rest?name=jojo",Greeting.class);
        assertEquals("Hello, jojo !",response.getMessage());
    }

    @Test
    @Description("Test where we do not provide the name param")
    public void greetWithoutName(@Autowired TestRestTemplate template){
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON,entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        if (response != null) {
            assertEquals("Hello, World !",response.getMessage());
        }
    }

}