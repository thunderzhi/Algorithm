package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/9 0:58
 */
public class case83 {
    public static void main(String[] args) {


    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode p = head;
        while(p.next!=null){
            if (p.val == p.next.val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }

        return head;
    }
}
