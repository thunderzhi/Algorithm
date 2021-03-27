package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/27 9:05
 */
public class case0204 {
    public ListNode partition(ListNode head, int x) {
        if (head==null){
            return null;
        }

        ListNode p = head;
        ListNode l1 = new ListNode(0);;
        ListNode l2 = new ListNode(0);;
        ListNode l1end = l1;
        ListNode l2end = l2;

        while(p!=null){
            if(p.val<x){
                //l1
                l1end.next = p;
                l1end = l1end.next;
            }
            else{
                //l2
                l2end.next = p;
                l2end = l2end.next;
            }
            p= p.next;
        }
        l2end.next = null;
        l1end.next = l2.next;
        return l1.next;

    }
}
