package org.sumanit.redis.redisson.configuration;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 苏曼 on 2019/7/19.
 */
@Configuration
public class RedissonConfiguration {

    @Bean
    public RedissonClient redissonClient(){
        System.out.println("rdisson");
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.9.7:6379").setDatabase(2).setPassword("123456");

        //config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});

        return Redisson.create(config);
    }
}
