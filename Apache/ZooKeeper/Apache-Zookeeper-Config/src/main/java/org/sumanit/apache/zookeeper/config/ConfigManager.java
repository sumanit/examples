package org.sumanit.apache.zookeeper.config;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 苏曼 on 2019/8/1.
 */
public class ConfigManager implements InitializingBean {
    private Map<String,Object> configMap;
    private Map<String,Listenter> listenterMap;

    private String zookeeperPath;

    private ZooKeeper zk;

    private void regiest(String key,Listenter listenter){
        listenterMap.put(key,listenter);
    }


    private void configUpudate(Map<String,Object> configMap){
        if(this.configMap == null){
            configMap.forEach((key,value)->{
                triggerListenter(key,null,value);
            });
        }
        Set<String> keySet = new HashSet();
        keySet.addAll(configMap.keySet());
        keySet.addAll(this.configMap.keySet());

        keySet.forEach(item->{
            Object oldValue = this.configMap.get(item);
            Object newValue = configMap.get(item);
            triggerListenter(item,oldValue,newValue);
        });

        this.configMap = configMap;
    }

    private void triggerListenter(String key,Object oldValue,Object newValue){
        Listenter listenter = listenterMap.get(key);
        if(listenter == null) {
            return;
        }
        ChangeType changeType = ChangeType.NONE;
        if(oldValue == null&& newValue == null){
            changeType = ChangeType.NONE;
        }else if(oldValue == null){
            changeType = ChangeType.ADD;
        }else if(newValue == null){
            changeType = ChangeType.DELETE;
        }else if(oldValue!=null&&newValue!=null&&!oldValue.equals(newValue)){
            changeType = ChangeType.UPDATE;
        }
        listenter.process(key,newValue,oldValue,changeType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                try {
                    byte[] data = zk.getData(zookeeperPath, false, new Stat());

                    zk.exists(zookeeperPath, this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        zk.exists(zookeeperPath,watcher);
    }
}
