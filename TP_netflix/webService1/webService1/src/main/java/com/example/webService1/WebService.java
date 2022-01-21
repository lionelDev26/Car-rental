package com.example.webService1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebService {
   
    @GetMapping("/")
    public String sayHello(){
        return "Hello !";
    }

}
