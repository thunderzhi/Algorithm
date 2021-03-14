package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:  链表 dequeue
 * @date 2021/3/14 22:26
 */
public class Queue {
    public Node head;//头节点,head中不存数据
    public Node tail;//尾节点后一位，tail不存数据
    public int cnt;//队列中元素个数

    Queue(){
        head =new Node(0);
        tail =new Node(0);
        cnt = 0;
        head.next = tail;
        head.pre =null;
        tail.next = null;
        tail.pre = head;
    }

    public int size(){
        return cnt;
    }

    public boolean isEmpty(){
        return head.next == tail;
    }

    //尾部入队 ，tail前插
    void push_back(int val){
        tail.insert_pre(new Node(val));
        cnt+=1;
    }
    //头部入队，head后插
    void push_front(int val){
        head.insert_next(new Node(val));
        cnt+=1;
    }

    //尾部出队，tail前删
    int pop_back(){
        if (isEmpty()){
            return  -1;
        }
        int ret = tail.pre.val;
        tail.del_pre();
        cnt-=1;
        return ret;
    }
    //头部出队，head后删
    int pop_front(){
        if (isEmpty()){
            return  -1;
        }
        int ret = head.next.val;
        head.del_next();
        cnt-=1;
        return ret;
    }

    //获取队首值
    int front(){
        return head.next.val;
    }
    int back(){
        return tail.pre.val;
    }
}
