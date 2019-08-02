package org.sumanit.apache.zookeeper.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.InitializingBean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by 苏曼 on 2019/8/1.
 */
public class ConfigManager implements InitializingBean {

    private Map<String,Object> configMap;

    private Map<String, Listener> listenerMap;

    private String zookeeperPath;

    private ZooKeeper zk;

    private ObjectMapper objectMapper;

    public void regiest(String key, Listener listenter){
        if(listenerMap == null){
            listenerMap = new HashMap<>();
        }
        listenerMap.put(key,listenter);
    }


    private void configUpudate(Map<String,Object> configMap){
        if(this.configMap == null){
            configMap.forEach((key,value)->{
                triggerListenter(key,null,value);
            });

        }else {
            Set<String> keySet = new HashSet();
            keySet.addAll(configMap.keySet());
            keySet.addAll(this.configMap.keySet());

            keySet.forEach(item -> {
                Object oldValue = this.configMap.get(item);
                Object newValue = configMap.get(item);
                triggerListenter(item, oldValue, newValue);
            });
        }
        this.configMap = configMap;
    }

    private void triggerListenter(String key,Object oldValue,Object newValue){
        if(listenerMap == null) return;
        Listener listenter = listenerMap.get(key);
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
        }else{
            return;
        }
        listenter.process(key,newValue,oldValue,changeType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadConfig();
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("数据发生变化了");
                try {
                    byte[] data = zk.getData(zookeeperPath, false, new Stat());
                    HashMap configMap = objectMapper.readValue(data, HashMap.class);
                    configUpudate(configMap);
                    zk.exists(zookeeperPath, this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        zk.exists(zookeeperPath,watcher);

    }

    public Map<String, Object> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, Object> configMap) {
        this.configMap = configMap;
    }

    public Map<String, Listener> getListenerMap() {
        return listenerMap;
    }


    public String getZookeeperPath() {
        return zookeeperPath;
    }

    public void setZookeeperPath(String zookeeperPath) {
        this.zookeeperPath = zookeeperPath;
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void loadConfig(){
        try {
            zk.create("/sumanit", "sumanit".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }catch (Exception e){

        }
        try {
            Map configMap = new HashMap();
            configMap.put("server.port",8080);
            byte[] bytes = objectMapper.writeValueAsBytes(configMap);
            zk.create("/sumanit/config", bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            setConfigMap(configMap);
        }catch (Exception e){

        }
    }
}
