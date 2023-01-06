package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@WebMvcTest(HelloController.class)

public class HelloControllerMockMvc {

    @Autowired
    private MockMvc mvc;

    @Test
    void autoWiringWorked(){
        assertNotNull(mvc);
    }

    @Test
    public void testHelloWithoutName() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("welcomes"))
                .andExpect(model().attribute("user","World"));
    }

    @Test
    public void testHelloWithName() throws Exception {
        mvc.perform(get("/hello").param("name","jojo").accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("welcomes"))
                .andExpect(model().attribute("user","jojo"));
    }


}
