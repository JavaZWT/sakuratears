package com.zwt.linklist;

/**
 * @Author: Little Fish
 * @Description: 循环链表
 * @Name: CircleLinkList.java
 * @Date: 2018年8月5日 下午6:48:57
 * @Version: 1.0
 */
public class CircleLinkList<T> {
	// 链表的每个节点类
	private class Node<T> {
		private Object data;// 每个节点的数据
		private Node<T> next;// 每个节点指向下一个节点的连接

		public Node(Object data) {
			this.data = data;
		}
	}

	Node<T> head, tail;
	Node<T> p;
	int size = 0;

	public CircleLinkList() {
		this.head = null;
		tail = head;
		p = head;
	}

	public int length() {
		return size;
	}

	/**
	 * 添加节点
	 * 
	 * @param data
	 */
	public void add(T data) {
		Node node = new Node<T>(data);
		if (head == null) {
			head = node;
			tail = head;
			p = head;
			size++;
		} else {
			node.next = head;
			head = node;
			tail.next = head;
			p = head;
			size++;
		}
	}

	/**
	 * 得到数据
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		int i = 0;
		p = head;
		while (i != index && p != tail) {
			i++;
			p = p.next;
		}
		return (T) p.data;
	}

	/** 
	 * @return
	 */
	public boolean isEmpty() {
		if (head != null)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		CircleLinkList c=new CircleLinkList<>();
		c.add(1);
		c.add(2);
		c.add(3);
	}
}
