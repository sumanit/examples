package org.sumanit.redis.redisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by 苏曼 on 2019/7/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedissonTest {
    @Autowired
    private RedissonClient redissonClient;
    @Test
    public void test(){
        new Thread(()->{
            System.out.println("线程1:开始");
            RLock dddd = redissonClient.getLock("dddd");
            try {
                System.out.println("线程1:开始加锁");
                dddd.lock(20, TimeUnit.SECONDS);
                System.out.println("线程1:加锁完成");
                System.out.println("线程1:开始睡眠");
                Thread.sleep(30000);
                System.out.println("线程1:睡眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程1:开始解锁");
                try {
                    dddd.unlock();
                }catch (Exception e){
                  //  e.printStackTrace();
                }
            }
            System.out.println("线程1:结束");
        }).start();

        new Thread(()->{
            System.out.println("线程2:开始");
            RLock dddd = redissonClient.getLock("dddd");
            try {
                System.out.println("线程2:开始加锁");
                dddd.lock(20, TimeUnit.SECONDS);
                System.out.println("线程2:加锁完成");
                System.out.println("线程2:开始睡眠");
                Thread.sleep(10000);
                System.out.println("线程2:睡眠结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程2:开始解锁");
                try {
                    dddd.unlock();
                }catch (Exception e){
                  //  e.printStackTrace();
                }
            }
            System.out.println("线程2:结束");

        }).start();
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
