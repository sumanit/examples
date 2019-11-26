package org.sumanit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 苏曼 on 2019/11/26.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
