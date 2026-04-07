package br.com.sonda_teste.aeronaveV2.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthConroller {

    @GetMapping("/")
    public String home(){
        return "ok";
    }

}
