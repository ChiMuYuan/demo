package com.security.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class MainController {

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }

    @PostMapping("/login_success")
    public String login() {
        return "/login_success";
    }

    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @GetMapping("/hello")
    public String hello3() {
        return "hello";
    }

}
