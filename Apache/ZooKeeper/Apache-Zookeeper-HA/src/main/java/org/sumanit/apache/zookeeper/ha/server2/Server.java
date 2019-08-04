package org.sumanit.apache.zookeeper.ha.server2;

import org.apache.zookeeper.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;

/**
 * Created by 苏曼 on 2019/8/2.
 */
@Component
public class Server implements CommandLineRunner, InitializingBean, ApplicationListener<WebServerInitializedEvent> {


    private int port;



    private ZooKeeper zk;

    @Override
    public void run(String... args) throws Exception {
       tryToMaster();
    }

    private void tryToMaster() throws  Exception{
            InetAddress address = InetAddress.getLocalHost();
            String ipPort = address.getHostAddress()+":"+port; //返回IP地址
        System.out.println("服务地址"+ipPort);
            try{
                zk.create("/service", "service".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }catch (Exception e){

            }
            try {
                zk.create("/service/master", ipPort.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                System.out.println("我成为主节点了");
            }catch (Exception e){
               // 尝试成为主节点失败  监听节点状态
                System.out.println("我是从节点");
                zk.exists("/service/master",event->{
                    System.out.println("ddd");
                    if(event.getType()== Watcher.Event.EventType.NodeDeleted){
                        try {
                            tryToMaster();
                        }catch (Exception e1){

                        }
                    }
                });
            }

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

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.port = event.getWebServer().getPort();
    }
}
