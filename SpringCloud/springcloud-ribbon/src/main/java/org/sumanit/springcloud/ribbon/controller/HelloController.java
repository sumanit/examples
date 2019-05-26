package org.sumanit.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * Created by 苏曼 on 2019/4/24.
 */
@RestController
public class HelloController {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/hello")
    public Object hello(){
        ServiceInstance instance = loadBalancer.choose("report");
        URI storesUri = URI.create(String.format("https://%s:%s", instance.getHost(), instance.getPort()));
        return storesUri.toString();
    }

}
