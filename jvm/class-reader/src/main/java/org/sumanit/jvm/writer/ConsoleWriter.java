package org.sumanit.jvm.writer;

public class ConsoleWriter implements  Writer{
    public void write(Object object) {
        System.out.println(String.valueOf(object));
    }
}
