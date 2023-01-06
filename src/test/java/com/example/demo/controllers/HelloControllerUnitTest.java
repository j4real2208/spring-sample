package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class HelloControllerUnitTest {
    @Test
    void sayHelloTestWithNameParam(){
        HelloController hc = new HelloController();
        Model model = new BindingAwareModelMap();
        model.addAttribute("user","jojo");
        String res = hc.sayHello("jojo",model);
        assertAll(
                () -> assertEquals("welcomes",res),
                () -> assertEquals("jojo",model.getAttribute("user"))
        );
    }    @Test
    void sayHelloTestWithNoNameParam(){
        HelloController hc = new HelloController();
        Model model = new BindingAwareModelMap();
        String res = hc.sayHello("World",model);
        assertAll(
                () -> assertEquals("welcomes",res),
                () -> assertEquals("World",model.getAttribute("user"))
        );
    }

}