package org.sumanit.springcloud.hystrix.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 苏曼 on 2019/4/2.
 */
@FeignClient(name="TEST-SERVICE",fallback = HelloWorldFallBack.class)
public interface HelloWorldRemote {
    @GetMapping("/hello")
    String hello();
}

