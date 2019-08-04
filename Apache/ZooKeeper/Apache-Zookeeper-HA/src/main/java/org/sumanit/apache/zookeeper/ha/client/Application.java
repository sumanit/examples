package org.sumanit.apache.zookeeper.ha.client;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@ComponentScan("org.sumanit.apache.zookeeper.ha.client.**")
@RestController
public class Application implements InitializingBean {
    private ZooKeeper zk;
    @GetMapping("/hello")
    public Object hello(){
        Stat stat = new Stat();
        try {
            byte[] data = zk.getData("/service/master", false, stat);
            String ipPort = new String(data);
            System.out.println(ipPort);
            return ipPort;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        zk = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接成功 ");
            }
        }, true);
    }
}
