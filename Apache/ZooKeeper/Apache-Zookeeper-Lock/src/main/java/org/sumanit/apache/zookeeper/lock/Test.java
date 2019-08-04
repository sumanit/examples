package org.sumanit.apache.zookeeper.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import javax.xml.stream.events.StartDocument;

public class Test {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接成功 ");
            }
        },true);
        Thread.sleep(2000L);

        UnfairLock unfairLock = new UnfairLock(zooKeeper);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(()->{
                System.out.println(index+": "+"开始尝试获取锁");
                boolean success = unfairLock.tryToLock("aaa");
                System.out.println(index+": "+"获取锁成功");
                System.out.println(index+": "+"开始处理业务");
                try {
                    Thread.sleep(10000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(index+": "+"业务处理完成");
                System.out.println(index+": "+"开始解锁");
                unfairLock.unLock("aaa");
                System.out.println(index+": "+"解锁完成");
            }).start();

        }
    }
}
