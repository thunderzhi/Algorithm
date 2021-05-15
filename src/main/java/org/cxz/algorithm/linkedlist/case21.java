package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/15 16:19
 */
public class case21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        ListNode h = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode t = h;

        while (p!=null&&q!=null){
            if(p.val<q.val){
                t.next=p;
                p=p.next;
            }
            else{
                t.next = q;
                q=q.next;
            }
            t =t.next;
        }
        t.next = q!=null?q:p;
        return h.next;
    }
}
