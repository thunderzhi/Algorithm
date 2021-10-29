package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/29 17:37
 */
public class case430 {
    public static void main(String[] args) {

    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    public Node flatten(Node head) {
        Node p = head;
        while(p!=null){
            if(p.child!=null){
                Node part2 = p.next;//
                Node child = p.child;

                Node t = flatten(child);
                p.child = null;
                p.next = t;
                t.prev = p;

                while(p.next!=null){
                    p = p.next;
                }
                p.next = part2;    //p is end of child
                if(part2!=null){
                    part2.prev = p;
                }

            }
            p = p.next;
        }
        return head;
    }
}
