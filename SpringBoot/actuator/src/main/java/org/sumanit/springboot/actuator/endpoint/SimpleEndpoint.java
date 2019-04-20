package org.sumanit.springboot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sumanit.springboot.actuator.model.User;

@Endpoint(id = "hello")
@Component
public class SimpleEndpoint  {
   /* @ReadOperation
    public String getHello(String name){
        return "get Hello:"+name;
    }*/
    @ReadOperation
    public String getHello(String user){
        return "get Hello:"+user;
    }
    @ReadOperation
    public String getHelloWithName(@Selector String name,@Selector String haha){
        return "get Hello With Name";
    }

    @WriteOperation
    public String postHello(String name,User user){
        return "post Hello:";
    }
    @DeleteOperation
    public String deleteHello(){
        return "delete Hello";
    }
}
