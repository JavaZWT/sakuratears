package com.zwt.linklist;

/**
 * @author zwt
 * @version 1.0
 * @desc 链表
 * @date 2021/3/15 10:59
 */
public class LinkedList {
    /**
     * Node节点
     */
    private static class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }
    }
    /**
     * 是否环链表
     * @param head
     * @return
     */
    public static boolean isLoop(Node head){
        Node fast = head;
        Node slow = head;
        while(slow !=null && fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 获取环链表入口节点
     * @param head
     * @return
     */
    public static Node getLoopStartNode(Node head){
        //快慢指针
        Node fast = head;
        Node slow = head;
        while(slow !=null && fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            //相遇退出，此时快慢指针位置为相遇点
            if(slow == fast){
                break;
            }
        }
        //如果没有环，return null
        if (fast==null || fast.next == null || fast.next.next == null) {
            return null;
        }

        slow = head;
        //如果有环，两个指针分别从链表头和相遇点出发，最终必定在环入口相遇
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    /**
     * 判断两个无环链表是否相交
     * @param node1
     * @param node2
     * @return
     */
    public static boolean noLoopNodeIsIntersect(Node node1,Node node2){
        if(node1==null||node2==null){
           return false;
        }

        Node temp1 = node1;
        Node temp2 = node2;

        //PS：两个链表相交，相交点及之后的节点会完全一致
        //1.拿到两链表长度
        int size1 = 0;
        int size2 = 0;
        while (temp1!=null){
            size1++;
            temp1 = temp1.next;
        }
        while (temp2!=null){
            size2++;
            temp2 = temp2.next;
        }

        //2.对于较长的链表，遍历到与短链表相同长度
        if(size1 > size2){
            int p1 = size1 -size2;
            while (p1>0){
                node1 = node1.next;
                p1--;
            }
        }else{
            int p2 = size2 -size1;
            while (p2>0){
                node2 = node2.next;
                p2--;
            }
        }

        //3.此时两个链表位置相同，同时向下遍历，如果有相同节点，说明相交
        while (node1!=node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        //找到相交点，返回成功
        if(node1!=null){
            return true;
        }
        //遍历到最后仍没有相交点，返回false
        return false;
    }

    /**
     * 判断两个环链表是否相交
     * @param head1 环链表1 头
     * @param loop1 环链表1 环入口节点
     * @param head2 环链表2 头
     * @param loop2 环链表2 环入口节点
     * @return
     */
    public static boolean bothLoopNodeIsIntersect(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1 = null;
        Node cur2 = null;
        //如果两个链表的环入口节点是同一个
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            //判断链表1和链表2谁到入口节点的长度长
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            //长的标记为cur1
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            //遍历长链表直到位置和短链表头位置相等
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            //两个链表长度相等开始遍历，直到相等时退出
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            //找到相交点，返回成功，否则返回失败
            if(cur1!=null){
                return true;
            }
            return false;
        } else {
            //环入口不是同一个，开始以环入口1为起点遍历环
            cur1 = loop1.next;
            while (cur1 != loop1) {
                //如果在环上找到了环入口2，说明就是一个环
                if (cur1 == loop2) {
                    return true;
                }
                cur1 = cur1.next;
            }
            //没找到环入口2，说明不是一个环，两个环链表也不可能相交
            return false;
        }
    }

    /**
     * 判断两个链表是否相交
     * @param head1
     * @param head2
     * @return
     */
    public static boolean nodeIsIntersect(Node head1,Node head2){
        if(head1==null || head2 == null){
            return false;
        }
        //拿到环入口节点
        Node loop1 = getLoopStartNode(head1);
        Node loop2 = getLoopStartNode(head2);
        //两链表都为无环链表
        if(loop1==null&&loop2==null){
            return noLoopNodeIsIntersect(head1,head2);
        }
        //两链表都为有环链表
        if(loop1!=null && loop2!=null){
            return bothLoopNodeIsIntersect(head1,loop1,head2,loop2);
        }
        //一个有环一个无环直接返回false
        return false;
    }
}
