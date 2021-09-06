package org.cxz.algorithm.linkedlist;

import java.util.HashSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/25 17:58
 */
public class case160 {

    public static void main(String[] args) {


    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        while (a!=null){
            set.add(a);
            a = a.next;
        }
        while (b!=null){
            if (set.contains(b)){
                break;
            }
            set.add(b);
            b = b.next;
        }
        if (b!=null){
            return b;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a!= b ){
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;
        }
        return a;


    }
}
