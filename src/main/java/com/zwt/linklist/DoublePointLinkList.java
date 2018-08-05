package com.zwt.linklist;

/**
 * @Author: Little Fish
 * @Description: 双端链表
 * @Name: DoublePointLinkList.java
 * @Date: 2018年8月5日 下午5:41:08
 * @Version: 1.0
 */
public class DoublePointLinkList {

	    private Node head;//头节点
	    private Node tail;//尾节点
	    private int size;//节点的个数
	    
	    private class Node{
	        private Object data;
	        private Node next;
	        
	        public Node(Object data){
	            this.data = data;
	        }
	    }
	    
	    public DoublePointLinkList(){
	        size = 0;
	        head = null;
	        tail = null;
	    }
	    
	    //链表头新增节点
	    public void addHead(Object data){
	        Node node = new Node(data);
	        if(size == 0){//如果链表为空，那么头节点和尾节点都是该新增节点
	            head = node;
	            tail = node;
	            size++;
	        }else{
	            node.next = head;
	            head = node;
	            size++;
	        }
	    }
	    
	    //链表尾新增节点
	    public void addTail(Object data){
	        Node node = new Node(data);
	        if(size == 0){//如果链表为空，那么头节点和尾节点都是该新增节点
	            head = node;
	            tail = node;
	            size++;
	        }else{
	            tail.next = node;
	            tail = node;
	            size++;
	        }
	    }
	    
	    //删除头部节点，成功返回true，失败返回false
	    public boolean deleteHead(){
	        if(size == 0){//当前链表节点数为0
	            return false;
	        }
	        if(head.next == null){//当前链表节点数为1
	            head = null;
	            tail = null;
	        }else{
	            head = head.next;
	        }
	        size--;
	        return true;
	    }
	    //判断是否为空
	    public boolean isEmpty(){
	        return (size ==0);
	    }
	    //获得链表的节点个数
	    public int getSize(){
	        return size;
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
		DoublePointLinkList l=new DoublePointLinkList();
		l.addHead(1);
		l.addHead(2);
		l.addHead(3);
		l.addTail(4);
		System.out.println(l.display());
	}
}
