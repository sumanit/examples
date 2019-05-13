package org.sumanit.springcloud.zuul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sumanit.springcloud.zuul.model.Info;

/**
 * Created by 苏曼 on 2019/5/13.
 */
@RestController
public class InfoController {

    @GetMapping("info")
    public Info infoGet(){
        Info info = new Info();
        info.setKey("suman");
        info.setValue("dddd");
        return info;
    }

}
