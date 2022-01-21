package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: tag  linkedlist
 * @date 2022/1/21 15:18
 */
public class offer029 {
    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };
    public Node insert(Node head, int insertVal) {
        Node p = head;
        Node max = head;
        while(p!=null){
            if(p.val>p.next.val){
                max = p;//find max
            }
            if(p.val<insertVal&&p.next.val>=insertVal){
                break; //find insert locat
            }
            if(head == p.next){
                p = max;
                break;
            }
            p = p.next;
        }

        if(p==null){
            head = new Node(insertVal,null);
            head.next = head;
            return head;
        }
        p.next = new Node(insertVal,p.next);
        return head;
    }

}
