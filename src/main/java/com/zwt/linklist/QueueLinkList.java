package com.zwt.linklist;

/**
 * @Author: Little Fish
 * @Description: 用双端链表实现队列
 * @Name: QueueLinkList.java
 * @Date: 2018年8月5日 下午5:51:51
 * @Version: 1.0
 */
public class QueueLinkList {
	    
	    private DoublePointLinkList dp;
	    
	    public QueueLinkList(){
	        dp = new DoublePointLinkList();
	    }
	    public void insert(Object data){
	        dp.addTail(data);
	    }
	    
	    public void delete(){
	        dp.deleteHead();
	    }
	    
	    public boolean isEmpty(){
	        return dp.isEmpty();
	    }
	    
	    public int getSize(){
	        return dp.getSize();
	    }
	    
	    public String display(){
	        return dp.display();
	    }
}
