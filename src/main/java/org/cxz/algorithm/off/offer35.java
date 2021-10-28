package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/27 23:28
 */
public class offer35 {
    public static void main(String[] args) {

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head){
        if(head==null){
            return head;
        }
        Node ret = new Node(0);
        Node p = head;
        Node q =null;
        //copy node
        while(p!=null){
            q = p.next;
            Node newnode = new Node(p.val);
            newnode.next = p.next;
            newnode.random = p.random;
            if(ret.next==null){
                ret.next = newnode;
            }
            p.next = newnode;
            p = q;
        }
        //move random;
        p = head.next;
        while(p!=null){
            q = p.random;
            if(q!=null){
                p.random = q.next;
            }
            else{
                p.random = q;
            }

            p = p.next;
            if (p!=null){
                p = p.next;
            }
        }
        // break copy
        p = head;
        Node odd = p;
        Node even = p.next;
        while(even!=null&&even.next!=null){
            odd.next= even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next =null;// last odd still point to even
        return ret.next;

    }
}
