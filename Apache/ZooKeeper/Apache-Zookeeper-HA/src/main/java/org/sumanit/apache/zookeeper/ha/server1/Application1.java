package org.sumanit.apache.zookeeper.ha.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 苏曼 on 2019/8/2.
 */
@EnableAutoConfiguration
@ComponentScan("org.sumanit.apache.zookeeper.ha.server1.**")
@RestController
public class Application1 {

    public static void main(String[] args) {
        SpringApplication.run(Application1.class,args);
    }

    @GetMapping("/hello")
    public Object hello(){
        return "application1";
    }
}
