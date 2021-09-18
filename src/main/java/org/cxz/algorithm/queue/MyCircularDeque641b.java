package org.cxz.algorithm.queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/17 23:49
 */
public class MyCircularDeque641b {

    class Node{
        int val;
        Node next;
        Node pre;
        Node(int value){
            val = value;
        }
    }

    public Node ret;//虚头
    public Node head;
    public Node tail;
    public int capacity;
    public int cnt;//实时数据点

    public static void main(String[] args) {

      // ["MyCircularDeque","insertFront","insertLast","getFront",
        // "insertLast","getFront","insertFront","getRear","getFront","getFront",
        // "deleteLast","getRear"]
///[[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]
        MyCircularDeque641b obj = new MyCircularDeque641b(5);
        // 设置容量大小为5
        obj.insertFront(7);			        // 返回 true
        obj.insertLast(0);			        // 返回 true
        obj.getFront();			        // 返回 true
        obj.insertLast(3);			        // 已经满了，返回 false
        obj.getFront();  				// 返回 2
        obj.insertFront(9);				        // 返回 true
        obj.getRear();			        // 返回 true
        obj.getFront();			        // 返回 true
        obj.deleteLast();				// 返回 4
        obj.getRear();
    }


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque641b(int k) {
        capacity = k;
        ret = new Node(0);
        ret.next = head;
        head =null;
        tail= null;

        cnt =0;
    }


    public String printstr(Node node){
        String msg = " ";
        while(node!=null){
            msg +=node.val+" ";
            System.out.println("printstr "+node.val);
            node = node.next;
        }
        return msg;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        Node p = new Node(value);
        p.next = ret.next;
        if(ret.next!=null){
            //ret 后插
            ret.next.pre = p;
        }
        p.pre = ret;
        ret.next=p;
        tail= cnt==0?p:tail;

        head = p;

        cnt+=1;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        Node p = new Node(value);
        if(tail!=null){
            p.next = tail.next;
            p.pre = tail;
            tail.next =p;
        }
        else{
            p.next = ret.next;
            p.pre = ret;
            ret.next =p;
            head = p;
        }
        tail = p;

        cnt+=1;
        return true;

    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }

        Node p = head;
        ret.next = p.next;
        if(p.next!=null){
            p.next.pre = ret;
        }
        head = p.next;
        cnt-=1;
        tail = cnt==0?null:tail;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        Node p = tail;
        if(p.pre!=null&&cnt>1){
            p.pre.next = p.next;
            tail = p.pre;
        }
        if(cnt==1){
            ret.next = p.next;
            tail = null;
            head = null;
        }
        cnt-=1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return capacity == cnt;
    }
}
