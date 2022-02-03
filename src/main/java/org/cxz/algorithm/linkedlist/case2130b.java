package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/2 23:43
 */
public class case2130b {

    ListNode t;
    public int pairSum(ListNode head) {
        t = head;
        ListNode p=head;//slow
        ListNode q=head;//fast
        while(q!=null&&q.next!=null){
            p = p.next;
            q = q.next.next;
        }
        //now p is half
        return getmax(head,p);
        //return ans;
    }

    public int getmax(ListNode head,ListNode node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int ans = getmax(head,node.next);
        ans =Math.max(ans,t.val+node.val);
        t =t.next;
        return ans;
    }
}
