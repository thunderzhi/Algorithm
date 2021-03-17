package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/14 16:02
 */
public class case138 {

    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        if (head==null){
            return null;
        }

        Node p = head;
        Node q = null;
        while (p!=null){
            q = new Node(p.val);
            q.random = p.random;
            q.next = p.next;
            p.next = q;
            p = q.next;
        }
        p = head.next;
        while(p!=null){
            if (p.random!=null){
                p.random = p.random.next;
            }
            else{
                p.random = null;
            }
            p = p.next;
            if (p!=null){
                p = p.next;
            }

        }
        Node newhead = head.next;
        p = head;
        while(p!=null){
            q = p.next;
            p.next = q.next;
            if (p.next!=null){
                q.next = p.next.next;
            }
            p = p.next;
        }

        return newhead;
        
    }

}
