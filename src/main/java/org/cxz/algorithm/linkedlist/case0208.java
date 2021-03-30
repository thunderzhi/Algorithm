package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/26 11:54
 */
public class case0208 {

    public ListNode detectCycle(ListNode head) {
        if (head ==null){
            return head;
        }
        ListNode ret = new ListNode(0);
        ret.next=head;
        ListNode p = head;
        ListNode q = head;
        ListNode k = head;
        while (q!=null&&q.next!=null){
            p = p.next;
            q = q.next.next;
            if (p ==q){
                break;
            }
        }
        if (q==null||q.next==null){
            return  null;
        }
        while(p!=k){
            p = p.next;
            k=k.next;
        }
        return p;

    }
}
