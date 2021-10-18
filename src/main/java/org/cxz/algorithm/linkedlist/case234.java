package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/18 15:32
 */
public class case234 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        ListNode v1 = new ListNode(0,head);
        ListNode p = head;
        ListNode h1 = head;
        int cnt = 0;
        while(p!=null){
            cnt++;
            p = p.next;
        }
        p = v1;
        ListNode q = v1;
        while(q!=null&&q.next!=null){
            p = p.next;
            q = q.next.next;
        }
        ListNode mid= p;
        ListNode h2 = realreverseN(mid.next,cnt/2) ;
        ListNode v2 = new ListNode(0,h2);
        boolean res = true;
        while(h1!=null&&h2!=null ){
            if(h1.val!=h2.val){
                res = false;
                break;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        mid.next = realreverseN(v2.next,cnt/2);
        return res;
    }

    public ListNode realreverseN(ListNode head,int k ){
        if(k==1){
            return head;
        }
        ListNode tail = head.next;
        ListNode p = realreverseN(head.next,k-1);
        head.next = tail.next;
        tail.next = head;
        return p;
    }
}
