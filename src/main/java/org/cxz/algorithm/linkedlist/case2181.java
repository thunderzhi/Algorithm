package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 21:29
 */
public class case2181 {

    //ver1 bymy
    public ListNode mergeNodes(ListNode head) {
        if(head==null) return head;
        head = head.next;
        ListNode s = head;
        ListNode p = null;
        ListNode q = p;
        while(s!=null){
            p = s;
            q = p.next;
            while(q.val!=0){
                p.val+=q.val;
                q = q.next;

            }
            s = q.next;
            p.next = s;
        }
        return head;
    }


    ListNode mergeNodes2(ListNode head) {
        if (head.next == null) return null;
        ListNode p = head;
        while (p.next.val != 0) {
            p.val += p.next.val;
            p.next = p.next.next;
        }
        p.next = mergeNodes(p.next);
        return head;
    }
}
