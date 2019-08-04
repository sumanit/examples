package org.sumanit.apache.zookeeper.lock;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
 
/**
 * zk 配置信息
 * @author zc.ding
 * @since 2019/3/23
 */
@Component
@PropertySource("classpath:zookeeper.properties")

public class ZkConfig {
    private String address;
    private int sessionTimeout;
    private long waitConnTimeout;
    private int fairLock;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public long getWaitConnTimeout() {
        return waitConnTimeout;
    }

    public void setWaitConnTimeout(long waitConnTimeout) {
        this.waitConnTimeout = waitConnTimeout;
    }

    public int getFairLock() {
        return fairLock;
    }

    public void setFairLock(int fairLock) {
        this.fairLock = fairLock;
    }
}