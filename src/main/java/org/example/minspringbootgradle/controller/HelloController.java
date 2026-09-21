package org.example.minspringbootgradle.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 访问路径：http://localhost:8081/hello
    @GetMapping("/hello")
    public String hello() {
        return "Hello SpringBoot！";
    }
}

