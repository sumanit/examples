package org.sumanit.springboot.condition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sumanit.springboot.condition.model.Teacher;

@RestController
public class TestController {
    @Autowired(required = false)
    private Teacher teacher;
    @RequestMapping("/hello")
    public String hello(){
        if(teacher != null){
            return "hello:"+teacher.getName();
        }
        return "hello";
    }
}
