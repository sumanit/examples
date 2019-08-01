package org.sumanit.apache.zookeeper.config;

/**
 * Created by 苏曼 on 2019/8/1.
 */
public interface Listenter<T> {
     void process(String config,T newValue,T oldValue,ChangeType changeType);
}
