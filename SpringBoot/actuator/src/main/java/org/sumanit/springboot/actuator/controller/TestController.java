package org.sumanit.springboot.actuator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 苏曼 on 2019/4/10.
 */
@Controller
public class TestController {

    @RequestMapping("/*")
    @ResponseBody
    public String all(){
        System.out.println("执行了all");
        return "all";
    }

}
