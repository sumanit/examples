package org.sumanit.apache.zookeeper.lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class UnfairLock {
    private static final String LOCK_NODE_PARETN="/sumanItLock";
    private ZooKeeper zk;
    private byte[] BUF = new byte[0];


    public UnfairLock(ZooKeeper zk) {
        this.zk = zk;
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception{
        zk.create(LOCK_NODE_PARETN,BUF, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public boolean tryToLock(String key){
        try {
            zk.create(LOCK_NODE_PARETN+"/"+key,BUF, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

            return true;
        } catch (Exception e) {

            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                zk.exists(LOCK_NODE_PARETN + "/" + key, event -> {
                    countDownLatch.countDown();
                });
                countDownLatch.await();
                return tryToLock(key);//锁被释放，再次尝试获取
            }catch (Exception e1){

            }

        }
        return false;
    }

    public boolean  unLock(String key){
        try {
            zk.delete(LOCK_NODE_PARETN+"/"+key,-1);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }

}
