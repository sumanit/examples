package org.sumanit.apache.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by 苏曼 on 2019/8/1.
 */

public class ApplicationTest {

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
    public void deleteNode(){
        try {
            zk.delete("/PERSISTENT", -1);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            zk.delete("/PERSISTENT_SEQUENTIAL",-1);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            zk.delete("/CONTAINER",-1);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            zk.delete("/PERSISTENT_WITH_TTL",-1);
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            zk.delete("/PERSISTENT_SEQUENTIAL_WITH_TTL",-1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void createNode() throws KeeperException, InterruptedException {
        List<ACL> acls;
        acls = ZooDefs.Ids.OPEN_ACL_UNSAFE;
        String result;

        result = zk.create("/PERSISTENT", "持久节点".getBytes(), acls, CreateMode.PERSISTENT);
        System.out.printf("创建节点:%s 结果: %s","持久节点",result);

        result = zk.create("/EPHEMERAL", "临时节点".getBytes(), acls, CreateMode.EPHEMERAL);
        System.out.printf("创建节点:%s 结果: %s","临时节点",result);

        result = zk.create("/PERSISTENT_SEQUENTIAL", "持久顺序节点".getBytes(), acls, CreateMode.PERSISTENT_SEQUENTIAL);
        System.out.printf("创建节点:%s 结果: %s","持久顺序节点",result);

        result = zk.create("/EPHEMERAL_SEQUENTIAL", "临时顺序节点".getBytes(), acls, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.printf("创建节点:%s 结果: %s","临时顺序节点",result);

        result = zk.create("/CONTAINER","容器节点".getBytes(),acls,CreateMode.CONTAINER);
        System.out.printf("创建节点:%s 结果: %s","容器节点",result);

        // 会报错  Unimplemented for /PERSISTENT_WITH_TTL
        try {
            result = zk.create("/PERSISTENT_WITH_TTL", "会过期持久节点".getBytes(), acls, CreateMode.PERSISTENT_WITH_TTL, new Stat(), 1000L);
            System.out.printf("创建节点:%s 结果: %s", "会过期持久节点", result);
        }catch (Exception e){
            e.printStackTrace();
        }
        //会报错  Unimplemented for /PERSISTENT_SEQUENTIAL_WITH_TTL
        try{
            result = zk.create("/PERSISTENT_SEQUENTIAL_WITH_TTL","会过期顺序持久节点".getBytes(),acls,CreateMode.PERSISTENT_SEQUENTIAL_WITH_TTL,new Stat(),1000L);
            System.out.printf("创建节点:%s 结果: %s","会过期持久顺序节点",result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void updateNode() throws KeeperException, InterruptedException {
        String result;
        Stat stat;
        result = zk.create("/data", "数据修改测试节点".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        stat = zk.setData("/data","数据修改后测试节点".getBytes(),-1);
        result = zk.create("/dataACL", "ACL修改测试节点".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        stat = zk.setACL("/dataACL",ZooDefs.Ids.OPEN_ACL_UNSAFE,-1);
    }



}
