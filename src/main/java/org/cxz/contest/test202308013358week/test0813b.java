package org.cxz.contest.test202308013358week;

import org.cxz.algorithm.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/13 10:11
 */
public class test0813b {
    public ListNode doubleIt(ListNode head) {
        Deque<ListNode> st = new ArrayDeque<>();
        ListNode p = head;
        while(p!=null){
            st.addLast(p);
            p = p.next;
        }
        int carry = 0;
        while(!st.isEmpty()){
            ListNode node = st.pollLast();
            int x = node.val*2+carry;
            int cur = x%10;
            carry = x/10;
            node.val = cur;
        }
        if(carry>0){
            ListNode vh = new ListNode(1);
            vh.next = head;
            return vh;
        }
        return head;

    }
}
