package org.sumanit.datastructure.list;

import java.util.Arrays;

/**
 * 顺序表
 */
public class SeqList {
    private Object[] elements;
    private int currentLength;

    public SeqList(int maxLength) {
        elements = new Object[maxLength];
        currentLength = 0;
    }

    /**
     * 清除元素
     */
    public void clear(){
        currentLength = 0;
    }
    /**
     * 判断列表是否为空
     */
    public boolean isEmpty(){
        return currentLength == 0;
    }

    /**
     * 获取元素
     * @param index 下标值
     * @return 元素
     */
    public Object get(int index){
        if(index < 0 || index > currentLength-1){
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    /**
     * 添加元素
     * @param element 添加的元素
     */
    public void add(Object element){
        if(currentLength == elements.length)
            throw new RuntimeException("表元素已满，无法继续插入");
        elements[currentLength]=element;
        currentLength++;
    }

    /**
     * 插入一个元素
     * @param index 插入的下标
     * @param element 插入的元素
     */
    public void insert(int index, Object element){
        if(currentLength == elements.length){
            throw new RuntimeException("表元素已满，无法继续插入");
        }
        if(index < 0 || index > currentLength){
            throw new RuntimeException("插入位置不合法");
        }
        for(int j=currentLength;j>index;j--){
            elements[j]=elements[j-1];
        }
        elements[index]=element;
        currentLength++;
    }

    /**
     * 列表的长度
     * @return
     */
    public int length(){
        return currentLength;
    }

    /**
     * 移除元素
     * @param index 需要移除元素所在的下标
     * @return 移除的元素
     */
    public Object remove(int index){
        if(index < 0 || index > currentLength-1){
            throw new IndexOutOfBoundsException();
        }
        Object removeElement = elements[index];
        for(int i= index;i<currentLength;i++){
            elements[i]=elements[i+1];
        }
        currentLength --;
        return removeElement;
    }

    /**
     * 获取元素所在的下标
     * @param element 需要获取下标的元素
     * @return 元素所在的下标
     */
    public int indexOf(Object element){
        for(int i=0;i<currentLength;i++){
            if(elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<currentLength;i++){
            sb.append(elements[i].toString());
            if(i<currentLength-1)
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
