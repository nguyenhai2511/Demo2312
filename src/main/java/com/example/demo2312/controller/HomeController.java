package com.example.demo2312.controller;

import com.example.demo2312.pojos.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.MediaType;

@RestController
public class HomeController {
    private static final String template = "Hello, %s";
    private List<Greeting> list = new ArrayList<>();
    private final AtomicInteger counter = new AtomicInteger();



    @GetMapping("/greeting")
    public List<Greeting> greeting(){
        return list;
    }

    @PostMapping("/addGreeting")
    public List<Greeting> addGreeting(@RequestParam(value = "name", defaultValue = "World") String name){
        list.add(new Greeting(counter.incrementAndGet(), String.format(template,name)));
        return list;
    }

    @PutMapping("/updateGreeting")
    public List<Greeting> updateGreeting(@RequestParam(value = "id", defaultValue = "1") int id, @RequestParam(value = "content", defaultValue = "DEMO") String content){
        Greeting greeting = new Greeting(id, String.format(template,content));
        list.set((int) (id - 1), greeting);
        return list;

    }

    @DeleteMapping("/deleteGreeting")
    public List<Greeting> deleteGreeting(@RequestParam(value = "id", defaultValue = "1") int id){
        list.remove(id -1);
        return list;
    }


}
