package com.example.demo2312;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Demo2312Application {
    @RequestMapping("/")
    public String welcome(){
        return "WELCOME TO AZURE";
    }
    public static void main(String[] args) {
        SpringApplication.run(Demo2312Application.class, args);
    }

}
