package org.sumanit.springcloud.feign.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "hello")
public interface HelloWithRibbonClient {
    @GetMapping("hello")
    String getHello();
    @PostMapping
    String postHello();
}
