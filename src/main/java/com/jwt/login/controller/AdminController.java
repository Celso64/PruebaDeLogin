package com.jwt.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/hola")
    public ResponseEntity<String> saludar(){
        return ResponseEntity.ok("HOLA ADMIN");
    }
}
