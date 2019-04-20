package org.sumanit.springboot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by 苏曼 on 2019/4/15.
 */
@Endpoint(id = "hello")
@Component
public class SimpleEndpoint  {
    @ReadOperation
    public String getHello(){
        return "get Hello";
    }

    @ReadOperation
    public String getHelloWithName(@Selector String name){
        return "get Hello";
    }

    @WriteOperation
    public String postHello(){
        return "post Hello";
    }
    @DeleteOperation
    public String deleteHello(){
        return "delete Hello";
    }
}
