package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/9 0:48
 */
public class case19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = new ListNode(0,head),p = ret,q=head;
        int k =n;
        while(k>0){
            q=q.next;
            k--;
        }
        while(q!=null){
            q= q.next;
            p=p.next;
        }
        ListNode tmp = p;
        p.next = p.next.next;
        return ret.next   ;
    }
}

