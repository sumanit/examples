package org.sumanit.springcloud.hystrix.client.feign;

import org.springframework.stereotype.Component;

/**
 * Created by 苏曼 on 2019/4/20.
 */
@Component
public class HelloWorldFallBack implements HelloWorldRemote {
    @Override
    public String hello() {
        return "fallBack";
    }
}
