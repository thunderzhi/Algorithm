package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/14 16:03
 */
public class Node {
    int val;
    Node next;
    Node pre;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
        this.pre  = null;
    }

    public void insert_pre(Node p){
        p.pre = pre;
        p.next = this;
        if (this.pre!=null){
            this.pre.next =p;
        }
        this.pre =p;
        return;
    }

    public void insert_next(Node p){
        p.next = this.next;
        p.pre = this;
        if (this.next!=null){
            this.next.pre = p;
        }
        this.next =p;
        return;
    }

    public void del_pre(){
        if(this.pre ==null){
            return;
        }
        Node p = this.pre;
        this.pre = p.pre;
        if (p.pre!=null){
            p.pre.next = this;
        }
        return;
    }

    public void del_next(){
        if(this.next ==null){
            return;
        }
        Node p = this.next;
        this.next = p.next;
        if (p.next!=null){
            p.next.pre = this;
        }
        return;
    }
}
