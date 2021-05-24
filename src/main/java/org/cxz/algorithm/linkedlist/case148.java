package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/18 11:17
 */
public class case148 {
    public static void main(String[] args) {

    }
    public ListNode sortList(ListNode head,ListNode tail) {
        if(head==null){
            return null ;
        }
        // System.out.println("head.val = " + head.val);
        if(head.next== tail){
            head.next =null;
            return head;
        }
        ListNode ret =new ListNode(0);
        ListNode slow =head;
        ListNode fast =head;
        while(fast!=tail&&fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        // System.out.println("mid.val = " + mid.val);
        ListNode left = sortList(head,mid);
        ListNode right = sortList(mid,tail);

        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right ){
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while(left!=null&&right!=null){
            if (left.val<right.val){
                p.next = left;
                left = left.next;
                p = p.next;
            }
            else{
                p.next = right;
                right = right.next;
                p = p.next;
            }
        }
        p.next = left!=null?left: right;
        return ret.next;
    }
}
