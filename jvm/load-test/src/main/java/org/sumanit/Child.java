package org.sumanit;

/**
 * Created by 苏曼 on 2019/12/11.
 */
public class Child extends Parent {
    public void child(){
        super.grandFather();
        System.out.println("child");
    }
}
