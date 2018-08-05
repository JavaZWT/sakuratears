package com.zwt.linklist;

/**
 * @Author: Little Fish
 * @Description: 有序链表
 * @Name: OrderLinkList.java
 * @Date: 2018年8月5日 下午5:56:10
 * @Version: 1.0
 */
public class OrderLinkList {

	    private Node head;
	    private int size;
	    
	    private class Node{
	        private int data;
	        private Node next;
	        
	        public Node(int data){
	            this.data = data;
	        }
	    }

	    public OrderLinkList(){
	    	size=0;
	        head = null;
	    }
	    
	    //插入节点，并按照从小打到的顺序排列
	    public void insert(int value){
	        Node node = new Node(value);
	        Node pre = null;
	        Node current = head;
	        while(current != null && value > current.data){
	            pre = current;
	            current = current.next;
	        }
	        if(pre == null){
	            head = node;
	            head.next = current;
	        }else{
	            pre.next = node;
	            node.next = current;
	        }
	        size++;
	    }
	    
	    //删除头节点
	    public void deleteHead(){
	        head = head.next;
	        size--;
	    }
	    
	    //判断是否为空
	    public boolean isEmpty(){
	        return (size ==0);
	    }
	    
	    //获取长度
	    public int getSize() {
	    	return size;
	    }
	    
	    public String display(){
	    	StringBuilder sb=new StringBuilder();
	        Node current = head;
	        while(current != null){
	            sb.append(current.data+" ");
	            current = current.next;
	        }
	        return sb.toString();
	    }
	    
	    public static void main(String[] args) {
	    	OrderLinkList l=new OrderLinkList();
	    	l.insert(1);
	    	l.insert(10);
	    	l.insert(4);
	    	System.out.println(l.display());
		}
}
