package org.sumanit.springboot.actuator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sumanit.springboot.actuator.model.User;

/**
 * Created by 苏曼 on 2019/4/10.
 */
@Controller
public class TestController {

    @RequestMapping("/user")
    @ResponseBody
    public String user(User user){
        System.out.println("执行了all");
        return "user name:"+user.getName();
    }
}
