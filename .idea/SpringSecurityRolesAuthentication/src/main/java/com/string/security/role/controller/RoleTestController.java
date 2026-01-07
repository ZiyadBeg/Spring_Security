package com.string.security.role.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleTestController {
    @GetMapping("/user")
    public String user() {
        return "Hello USER";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello ADMIN";
    }
    @GetMapping("/boss")
    public String boss() {
        return "Hello Ziyad boss";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin-only")
    public String adminOnly() {
        return "Only Admin";
    }
}
