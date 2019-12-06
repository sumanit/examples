package org.sumanit;

/**
 * Created by 苏曼 on 2019/12/6.
 */
public class Test {

    private static int value1= 0;

    public static int value3=2;
    private int value2 = 4;
    static{
        value1=4;
        value3=3;
    }
    {
        value3=5;
        value2=6;
    }


    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(value3);
    }
}
