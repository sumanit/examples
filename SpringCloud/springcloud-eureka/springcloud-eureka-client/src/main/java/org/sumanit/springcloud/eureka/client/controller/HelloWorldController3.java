package org.sumanit.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sumanit.springcloud.eureka.client.feign.HelloWorldRemote;

@RestController
public class HelloWorldController3 {

    @Autowired
    private HelloWorldRemote helloWorldRemote;
    @RequestMapping("/hello3")
    public String helloWorld(){
        return helloWorldRemote.hello();
    }
}
