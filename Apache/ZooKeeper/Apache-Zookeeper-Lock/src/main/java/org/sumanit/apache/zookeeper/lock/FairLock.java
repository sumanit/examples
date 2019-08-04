package org.sumanit.apache.zookeeper.lock;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

public class FairLock {
    private static final String LOCK_NODE_PARETN="/sumanItLock";
    private ZooKeeper zk;
    private byte[] BUF = new byte[0];
    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public FairLock(ZooKeeper zk) {
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
            System.out.println("开始创建节点");
            String currentNode =  zk.create(LOCK_NODE_PARETN+"/"+key,BUF, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            System.out.println("创建节点成功"+currentNode);
            THREAD_LOCAL.set(currentNode);
            List<String> children = zk.getChildren(LOCK_NODE_PARETN, false);
            children = children.stream().filter(item -> item.startsWith(key)).sorted().collect(Collectors.toList());
            System.out.println(children.get(0)+"\t"+currentNode);
            if(currentNode.endsWith(children.get(0))){//如果自己是第一个 获取到锁
                return true;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            for (int i = 1; i < children.size() ; i++) {
                if(currentNode.endsWith(children.get(i))){
                    zk.exists(LOCK_NODE_PARETN+"/"+children.get(i-1),watchedEvent -> {
                        countDownLatch.countDown();
                    });
                    break;
                }
            }
            countDownLatch.await();

            return true;
        } catch (Exception e) {
             e.printStackTrace();
        }
        return false;
    }

    public boolean  unLock(){
        try {
            zk.delete(THREAD_LOCAL.get(),-1);
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
        return false;
    }
}
