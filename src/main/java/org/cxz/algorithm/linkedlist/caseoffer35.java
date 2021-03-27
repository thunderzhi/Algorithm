package org.cxz.algorithm.linkedlist;

import javax.swing.text.html.HTMLEditorKit;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/24 17:04
 */
public class caseoffer35 {
    public static class Node{
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }



    }

    public static void main(String[] args) {
        Node head = new Node(7);
        Node b = new Node(13);
        Node c = new Node(11);
        Node d = new Node(10);
        Node e = new Node(1);
        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        head.random = null;
        b.random = head;
        c.random =e;
        d.random =c;
        e.random = head;

        b.random = head;

        Node node = copyRandomList(head);
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

    }

    public static Node copyRandomList(Node head) {
        //copynode
        if (head==null){
            return null;
        }

        Node p = new Node(0);
        Node q = new Node(0);
        p = head;
        while (p !=null){
            copynode(p);
            if(p.next!=null){
                p = p.next.next;
            }
        }
        p = head.next;
        while(p!=null){
            if(p.random!=null){
                p.random = p.random.next;
            }
            else{
                p.random =null;
            }
            p = p.next;
            if(p!=null){
                p = p.next;
            }
        }
        Node newhead = head.next;
        p = head;
        while(p!=null){
            q = p.next;//q 是新node
            p.next = q.next;
            if (p.next!=null) {
                q.next = p.next.next;
            }
            p = p.next;
        }
        return newhead;
    }

    //复制一个node，放在原node之后
    public static void copynode(Node node){
        Node copy = new Node(0);
        copy.val = node.val;
        copy.next = node.next;
        copy.random = node.random;
        node.next = copy;
    }

}
