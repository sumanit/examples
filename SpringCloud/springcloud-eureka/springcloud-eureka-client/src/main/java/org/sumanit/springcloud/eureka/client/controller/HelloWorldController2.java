package org.sumanit.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController2 {


    @Autowired
    private RestTemplate restTemplate2;

    @RequestMapping("/hello2")
    public String helloWorld(){
        return restTemplate2.getForObject("http://TEST-SERVICE/hello",String.class);
    }
}
