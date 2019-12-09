package org.sumanit;

/**
 * Created by 苏曼 on 2019/12/6.
 */
public class Test {
    private int value1;
    private static int i = 2;
    static {
        System.out.println(i);
    }
    public void metehod1(){
        System.out.println(value1);
        System.out.println(i);
    }
}
