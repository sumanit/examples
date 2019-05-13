package org.sumanit.springcloud.feign.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url="127.0.0.1:8080",name = "hello1")
public interface HelloClient {
    @GetMapping("hello")
    String getHello();
    @PostMapping
    String postHello();
}
