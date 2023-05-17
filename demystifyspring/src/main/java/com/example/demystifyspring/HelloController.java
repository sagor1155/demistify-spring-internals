package com.example.demystifyspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloMessageProvider msgProvider;
    public HelloController(HelloMessageProvider msgProvider) {
        this.msgProvider = msgProvider;
    }

    @GetMapping("/hello")
    public String hello() {
        return this.msgProvider.getMessage();
    }
}
