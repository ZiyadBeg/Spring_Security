package com.string.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeCntrl {

    @GetMapping("/public")
    public String publicApi() {
        return "This is PUBLIC API";
    }

    @GetMapping("/secure")
    public String secureAPI() {
        return "Hello Secure World";
    }
}
