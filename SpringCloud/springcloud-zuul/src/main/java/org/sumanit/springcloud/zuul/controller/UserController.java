package org.sumanit.springcloud.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sumanit.springcloud.zuul.model.User;

/**
 * Created by 苏曼 on 2019/5/13.
 */
@RestController
public class UserController {
    @GetMapping("user")
    public User userGet(){
        User result = new User();
        result.setName("suman");
        result.setAge(29);
        result.setGender(1);
        return result;
    }
}
