package org.sumanit.apache.zookeeper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by 苏曼 on 2019/8/2.
 */
@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private ConfigManager configManager;
    @Override
    public void run(String... args) throws Exception {
        configManager.regiest("server.port", new Listener() {
            @Override
            public void process(String config, Object newValue, Object oldValue, ChangeType changeType) {
                System.out.println("newValue:"+newValue);
            }
        });
    }
}
