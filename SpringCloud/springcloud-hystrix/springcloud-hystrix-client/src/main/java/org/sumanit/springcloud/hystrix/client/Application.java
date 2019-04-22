package org.sumanit.springcloud.hystrix.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
public class Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Bean(name="restTemplate1")
    public RestTemplate restTemplate1() {
        return new RestTemplate();
    }

    @Bean(name="restTemplate2")
    @LoadBalanced
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }
}
