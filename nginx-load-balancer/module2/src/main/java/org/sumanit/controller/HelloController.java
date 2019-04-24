package org.sumanit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by 苏曼 on 2019/4/24.
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "hello2"+new Date().getTime();
    }
}