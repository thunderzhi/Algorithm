package org.cxz.contest.test11020230805dweek;

import org.cxz.algorithm.linkedlist.ListNode;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/5 20:08
 */
public class test0805b {
    public int gcd(int a ,int b){
        if(b>0) return gcd(b,a%b);
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode n1 = head, n2 = head.next;
        int g = gcd(n1.val,n2.val);
        System.out.println("g = " + g+ " n1 "+n1.val + " n2 "+n2.val);
        ListNode node = new ListNode(g);
        n1.next = node;
        node.next =insertGreatestCommonDivisors(n2);
        return n1;
    }
}
