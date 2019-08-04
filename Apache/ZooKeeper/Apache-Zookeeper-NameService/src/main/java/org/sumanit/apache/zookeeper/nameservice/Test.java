package org.sumanit.apache.zookeeper.nameservice;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        ZooKeeper  zk = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接成功 ");
            }
        }, true);
        Naming naming = new Naming(zk);
        naming.registered("Service","127.0.0.1:2323");
        naming.registered("Service","127.0.0.1:2324");
        List<String> service = naming.readAll("Service");
        for (String item : service) {
            System.out.println(item);
            byte[] data = zk.getData("/NameService/" + item, false, new Stat());
            System.out.println(new String(data));
        }
    }
}
