package com.zwt.stack;

/**
 * @Author: Little Fish
 * @Description: 自己用数组实现一个Stack，遵循FILO，LIFO。
 * @Name: Stack.java
 * @Date: 2018年7月28日 下午10:50:57
 * @Version: 1.0
 */
public class Stack {
	private Object[] members;
	private int size;
	
	public Stack(int initCapacity) throws Exception{
		if(initCapacity<=0) {
			throw new Exception();
		}
		this.members=new Object[initCapacity];
	}
	
	public Stack() {
		this.members=new Object[10];
	}
	
	//元素入栈
	public synchronized void push(Object o){
		ensureCapacity(size+1);
		members[size++]=o;
	}
	
	//元素出栈
	public synchronized Object pop() throws Exception{
		if(size<=0) {
			throw new Exception();
		}
		return members[--size];
	}
	
	public synchronized Object peek() throws Exception{
		if(size<=0) {
			throw new Exception();
		}
		return members[size-1];
	}
	
	
	//确认容量
	private synchronized void ensureCapacity(int minCapacity) {
		//size+1比数组长度要长，扩容
		if(minCapacity-members.length>0) {
	        int oldCapacity = members.length;
	        Object oldMembers=members;
	        //扩容到二倍
	        int newCapacity = 2 * oldCapacity ;
	        //扩容后还不够或者超过int最大值，就直接赋值size+1
	        if (newCapacity - minCapacity < 0)
	            newCapacity = minCapacity;
	        members=new Object[newCapacity];
	        //拷贝数组
	        System.arraycopy(oldMembers, 0, members, 0, size);
	        oldMembers=null;
		}
	}
	
	public static void main(String[] args) throws Exception{
		Stack s=new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
}
