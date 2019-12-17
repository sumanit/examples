package org.sumanit.concurrency;

public class VolatileTest {

    public static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(()->{
            while (true) {
                if (flag) {
                    System.out.println("ThreadA : flag is " + flag);
                    break;
                }
            }
            System.out.println("ThreadA End");
        });
        Thread threadB = new Thread(()->{
            flag = true;
            System.out.println("ThreadB : flag is " + flag);
        });

        threadA.start();
        Thread.sleep(1000l);//为了保证threadA比threadB先启动，sleep一下
        threadB.start();


    }
}

