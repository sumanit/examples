package org.sumanit.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
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
