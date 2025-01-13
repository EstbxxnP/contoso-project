package com.contoso.contoso_springboot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/public")
    public String publicSite() {
        return "Este es un espacio público!, no requiere autorización";
    }

    @GetMapping("/private")
    public String privateSite() {
        return "Este es un espacio privado, estás autorizado!";
    }
}

