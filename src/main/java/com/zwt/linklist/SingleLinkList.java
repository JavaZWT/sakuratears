package com.zwt.linklist;

/**
 * @Author: Little Fish
 * @Description: 单向链表
 * @Name: SingleLinkList.java
 * @Date: 2018年8月5日 下午4:48:46
 * @Version: 1.0
 */
public class SingleLinkList {

	    private int size;//链表节点的个数
	    private Node head;//头节点
	    
	    public SingleLinkList(){
	        size = 0;
	        head = null;
	    }
	    
	    //链表的每个节点类
	    private class Node{
	        private Object data;//每个节点的数据
	        private Node next;//每个节点指向下一个节点的连接
	        
	        public Node(Object data){
	            this.data = data;
	        }
	    }
	    
	    //在链表头添加元素
	    public Object addHead(Object obj){
	        Node newHead = new Node(obj);
	        if(size == 0){
	            head = newHead;
	        }else{
	            newHead.next = head;
	            head = newHead;
	        }
	        size++;
	        return obj;
	    }
	    
	    //在链表头删除元素
	    public Object deleteHead(){
	        Object obj = head.data;
	        head = head.next;
	        size--;
	        return obj;
	    }
	    
	    //查找指定元素，找到了返回节点Node，找不到返回null
	    public Node find(Object obj){
	        Node current = head;
	        int tempSize = size;
	        while(tempSize > 0){
	            if(obj.equals(current.data)){
	                return current;
	            }else{
	                current = current.next;
	            }
	            tempSize--;
	        }
	        return null;
	    }
	    
	    //删除指定的元素，删除成功返回true
	    public boolean delete(Object value){
	        if(size == 0){
	            return false;
	        }
	        Node current = head;
	        Node previous = head;
	        while(current.data != value){
	            if(current.next == null){
	                return false;
	            }else{
	                previous = current;
	                current = current.next;
	            }
	        }
	        //如果删除的节点是第一个节点
	        if(current == head){
	            head = current.next;
	            size--;
	        }else{//删除的节点不是第一个节点
	            previous.next = current.next;
	            size--;
	        }
	        return true;
	    }
	    
	    //判断链表是否为空
	    public boolean isEmpty(){
	        return (size == 0);
	    }
	    
	    //显示节点信息
	    public String display(){
	    	
	    	StringBuilder sb=new StringBuilder();
	        if(size >0){
	            Node node = head;
	            int tempSize = size;
	            if(tempSize == 1){//当前链表只有一个节点
	                sb.append("["+node.data+"]");
	                return sb.toString();
	            }
	            while(tempSize>0){
	                if(node.equals(head)){
	                    sb.append("["+node.data+"->");
	                }else if(node.next == null){
	                	sb.append(node.data+"]");
	                }else{
	                	sb.append(node.data+"->");
	                }
	                node = node.next;
	                tempSize--;
	            }
	            return sb.toString();
	        }else{//如果链表一个节点都没有，直接打印[]
	        	sb.append("[]");
	        	return sb.toString();
	        }     
	    }
	    
	    public static void main(String[] args) {
	    	SingleLinkList sll=new SingleLinkList();
	    	sll.addHead(1);
	    	sll.addHead(2);
	    	sll.addHead(3);
	    	System.out.println(sll.display());
		}
}
