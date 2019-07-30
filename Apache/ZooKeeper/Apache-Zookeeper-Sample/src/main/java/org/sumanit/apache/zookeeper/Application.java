package org.sumanit.apache.zookeeper;

import org.apache.zookeeper.*;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接成功 ");
            }
        },true);

        zooKeeper.create("/eee1","ddd".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        List<String> children = zooKeeper.getChildren("/", false);
        for (String child : children) {
            System.out.println(child);
        }

    }
}
