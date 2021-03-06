package org.sumanit.springcloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${info.name:none}")
    private String infoName;

    @RequestMapping("/hello")
    public String config(){
        return infoName;
    }
}
