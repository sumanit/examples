package org.sumanit.apache.zookeeper.nameservice;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;  
import org.apache.zookeeper.ZooKeeper;  
import org.apache.zookeeper.ZooDefs.Ids;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Naming {  
    private ZooKeeper zk = null; // ZooKeeper对象  
    private String nameroot = "/NameService";
  
    /** 
     * @函数：命名服务构造函数 
     * @参数：zk的地址端口 描述：初始化zk实例，创建命名服务根路径 
     */  
    public Naming(ZooKeeper zooKeeper) {
       this.zk = zooKeeper;
        // 判断是否有/NameService，如果没有，则创建该路径，用来作为所有的集中配置信息的根目录  
        try {  
            if (zk.exists(nameroot, false) == null) {  
                zk.create(nameroot, "".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println(nameroot + " create success!");  
            }  
        } catch (KeeperException e) {  
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }  

    /** 
     * @函数：注册一个全局名字 
     * @描述：待注册的名字字符串name，在zk中创建一个/NameService/name的znode路径 
     * @参数： 待注册的名字字符串name 
     * @返回值： 0 表示注册成功 -1 表示出错 1 表示该命名已被注册 
     */  
    @SuppressWarnings("finally")  
    public boolean registered(String name,String nameValue) {
        String path = nameroot + "/" + name;  

        try {  
            if (zk.exists(path, false) == null) {  
                zk.create(path, nameValue.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
                System.out.println(name + " registered success!");  
            } else {  

                System.out.println(name + " is exists, can not regist again!");  
            }
            return true;
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }  
  
    /** 
     * @函数：注销一个全局名字 
     * @描述：待注销的名字字符串name，在zk中删除/NameService/name的znode路径 
     * @参数： 待注销的名字字符串name 
     * @返回值： 0 表示注销成功 -1 表示出错 1 表示该命名未注册，不存在命名服务系统中 
     */  
    @SuppressWarnings("finally")  
    public boolean unRegistered(String name) {
        String path = nameroot + "/" + name;
        try {  
            if (zk.exists(path, false) != null) {  
                zk.delete(path, -1);  
                System.out.println(name + " unRegistered success!");
            } else {
                System.out.println(name + " is not exists, can not unRegistered!");
            }
            return true;
        } catch (KeeperException e) {  
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;

    }  
  
    /** 
     * @函数：获取命名服务系统的所有命名 
     * @描述： 
     * @参数： 
     * @返回值：命名列表 
     */  
    public List<String> readAll() {
        List<String> namelist = new ArrayList<String>();
        try {  
            namelist = zk.getChildren(nameroot, false);  
        } catch (KeeperException e) {  
            e.printStackTrace();
        } catch (InterruptedException e) {  
            e.printStackTrace();
        }  
        return namelist;  
    }

    /**
     * @函数：获取命名服务系统的所有命名
     * @描述：
     * @参数：
     * @返回值：命名列表
     */
    public List<String> readAll(String match) {
        List<String> namelist = new ArrayList<String>();
        try {
            namelist = zk.getChildren(nameroot, false);
            namelist = namelist.stream().filter(item->item.indexOf(match)!=-1).collect(Collectors.toList());
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return namelist;
    }

}  