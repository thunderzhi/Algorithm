package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/15 15:38
 */
public class case02 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode t = h;
        int j = 0;
        while(p!=null||q!=null){

            int a = p ==null?0: p.val;
            int b = q ==null?0: q.val;
            int m = (a+b+j);
            j = m>=10?1:0;
            ListNode tmp = new ListNode(m % 10);
            t.next = tmp;
            t = t.next;
            p =p==null?null: p.next;
            q = q==null? null: q.next;
        }


        if( j>0){
            ListNode tmp = new ListNode(j);
            t.next = tmp;

        }
        return h.next;
    }
}
