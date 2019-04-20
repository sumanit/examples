package org.sumanit.springcloud.hystrix.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sumanit.springcloud.hystrix.client.feign.HelloWorldRemote;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldRemote helloWorldRemote;
    @RequestMapping("/hello")
    public String helloWorld(){
        return helloWorldRemote.hello();
    }
}
