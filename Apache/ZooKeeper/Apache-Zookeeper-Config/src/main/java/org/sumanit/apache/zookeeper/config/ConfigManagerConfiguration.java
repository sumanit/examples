package org.sumanit.apache.zookeeper.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 苏曼 on 2019/8/2.
 */
@Configuration
public class ConfigManagerConfiguration {
    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public ConfigManager configManager(){
        ConfigManager configManager = new ConfigManager();
        try {
            ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("连接成功 ");
                }
            }, true);


            configManager.setZk(zk);
            configManager.setZookeeperPath("/sumanit/config");
            configManager.setObjectMapper(objectMapper);
        }catch (Exception e){
            e.printStackTrace();
        }
        return configManager;
    }
}
