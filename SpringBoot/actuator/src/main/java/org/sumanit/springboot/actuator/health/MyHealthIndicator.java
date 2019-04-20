package org.sumanit.springboot.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * Created by 苏曼 on 2019/4/16.
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.status(Status.UNKNOWN).withDetail("Error Code", errorCode).build();

        }

        return Health.up().build();
    }
    public int check(){
        return 2;
    }
}
