package com.helloworld.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class HelloWorldController {

    @GetMapping("/")
    public ResponseEntity<String> execute() {
        return ResponseEntity.ok().body("Hello World");
    }
}
