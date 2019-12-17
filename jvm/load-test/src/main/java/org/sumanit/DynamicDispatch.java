package org.sumanit;

public class DynamicDispatch{
    static abstract class Human{
        protected void sayHello(){
            System.out.println("human say hello");
        }
    }
    static class Man extends Human{
        protected void sayHello(){
            System.out.println("man say hello");
        }
    }
    static class Woman extends Human{
        protected void sayHello(){
            System.out.println("woman say hello");
        }
    }

    public static void main(String[]args){
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }
}