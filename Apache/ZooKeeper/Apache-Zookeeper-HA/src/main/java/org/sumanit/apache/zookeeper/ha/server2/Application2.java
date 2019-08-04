package org.sumanit.apache.zookeeper.ha.server2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sumanit.apache.zookeeper.ha.server1.Application1;

/**
 * Created by 苏曼 on 2019/8/2.
 */
@EnableAutoConfiguration
@ComponentScan("org.sumanit.apache.zookeeper.ha.server2.**")
@RestController
public class Application2 {

    public static void main(String[] args) {
        SpringApplication.run(Application2.class,args);
    }

    @GetMapping("/hello")
    public Object hello(){
        return "application2";
    }
}
