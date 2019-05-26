package org.sumanit.springcloud.gateway.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConroller {

    @GetMapping("/hello")
    public String hello(){

        return "hello";
    }
}
