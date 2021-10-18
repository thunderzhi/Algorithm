package org.cxz.algorithm.dynamic;

import org.cxz.algorithm.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/18 17:53
 */
public class caseO0201 {
    public static void main(String[] args) {

    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        Set<Integer> set = new HashSet<Integer>();
        ListNode p = head;
        ListNode q = head.next;
        set.add(head.val);
        while(q!=null){
            if(set.add(q.val)){
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        p.next =q;
        return head;
    }
}
