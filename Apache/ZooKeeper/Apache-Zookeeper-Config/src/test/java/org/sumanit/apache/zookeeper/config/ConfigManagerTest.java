package org.sumanit.apache.zookeeper.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 苏曼 on 2019/8/2.
 */
public class ConfigManagerTest {
    private ObjectMapper objectMapper = new ObjectMapper();
    private ZooKeeper zk = null;
    @Before
    public void init() throws IOException {
        if(zk == null) {
            zk = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("连接成功 ");
                }
            }, true);
        }
    }
    @Test
    public void changeConfig() throws JsonProcessingException, KeeperException, InterruptedException {
        Map configMap = new HashMap<>();
        configMap.put("server.port",9191);
        configMap.put("server.name","dddd");
        byte[] bytes = objectMapper.writeValueAsBytes(configMap);
        zk.setData("/sumanit/config",bytes,-1);

    }

}
