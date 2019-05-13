package org.sumanit.springcloud.feign.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public Object getHello(){
        return "get Hello";
    }
    @PostMapping
    public Object postHello(){
        return "post Hello";
    }
}
