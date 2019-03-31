package org.sumanit.springcloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
}
