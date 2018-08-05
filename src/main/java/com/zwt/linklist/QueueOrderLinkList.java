package com.zwt.linklist;

/**
 * @Author: Little Fish
 * @Description: 有序链表实现优先级队列
 * @Name: QueueOrderLinkList.java
 * @Date: 2018年8月5日 下午6:28:37
 * @Version: 1.0
 */
public class QueueOrderLinkList {
    
    private OrderLinkList dp;
    
    public QueueOrderLinkList(){
        dp = new OrderLinkList();
    }
    public void insert(int data){
        dp.insert(data);
    }
    
    public void delete(){
        dp.deleteHead();
    }
    
    public int getSize() {
    	return dp.getSize();
    }
    
    public boolean isEmpty() {
    	return dp.isEmpty();
    }
    
    public String display(){
        return dp.display();
    }
}
