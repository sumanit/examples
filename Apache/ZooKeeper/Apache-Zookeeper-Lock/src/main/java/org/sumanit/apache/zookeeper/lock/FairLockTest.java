package org.sumanit.apache.zookeeper.lock;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class FairLockTest {

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接成功 ");
            }
        },true);
        Thread.sleep(2000L);

        FairLock unfairLock = new FairLock(zooKeeper);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(()->{
                System.out.println(index+": "+"开始尝试获取锁");
                boolean success = unfairLock.tryToLock("bbb");
                System.out.println(index+": "+"获取锁成功");
                System.out.println(index+": "+"开始处理业务");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(index+": "+"业务处理完成");
                System.out.println(index+": "+"开始解锁");
                unfairLock.unLock();
                System.out.println(index+": "+"解锁完成");
            }).start();

        }
    }
}
