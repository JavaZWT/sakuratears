package com.zwt.linklist;

/**
 * @Author: Little Fish
 * @Description: 用单向链表实现栈
 * @Name: StackSingleLinkList.java
 * @Date: 2018年8月5日 下午5:27:43
 * @Version: 1.0
 */
public class StackSingleLinkList {

	public class StackSingleLink {
	    private SingleLinkList link;
	    
	    public StackSingleLink(){
	        link = new SingleLinkList();
	    }
	    
	    //添加元素
	    public void push(Object obj){
	        link.addHead(obj);
	    }
	    
	    //移除栈顶元素
	    public Object pop(){
	        Object obj = link.deleteHead();
	        return obj;
	    }
	    
	    //判断是否为空
	    public boolean isEmpty(){
	        return link.isEmpty();
	    }
	    
	    //打印栈内元素信息
	    public String display(){
	        return link.display();
	    }
	}
}
