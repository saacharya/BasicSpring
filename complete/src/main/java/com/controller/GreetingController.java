package com.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.Greeting;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/autoincrease")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Santosh") String name) {
        return new Greeting(counter.incrementAndGet(),
                            "Welcome "+ name);
    }
}
