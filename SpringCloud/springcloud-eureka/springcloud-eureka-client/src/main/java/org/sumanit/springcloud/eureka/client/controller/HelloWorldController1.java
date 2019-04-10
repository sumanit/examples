package org.sumanit.springcloud.eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloWorldController1 {

    @Autowired
    private LoadBalancerClient client;

    @Autowired
    private RestTemplate restTemplate1;

    @RequestMapping("/hello1")
    public String helloWorld(){
        ServiceInstance serviceInstance = client.choose("TEST-SERVICE");
        String helloServiceUrl = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/hello";
        System.out.println(helloServiceUrl);
        return restTemplate1.getForObject(helloServiceUrl,String.class);
    }
}
