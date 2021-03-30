package org.cxz.algorithm.linkedlist;


import org.cxz.algorithm.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/24 16:13
 */
public class case0202 {
    public static void main(String[] args) {
        ListNode head = NodeUtil.InitLinkList(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        new case0202().kthToLast(head,2);
    }

    public int kthToLast(ListNode head, int k) {
        ListNode p = new ListNode(0);
        ListNode q = new ListNode(0);
        if(head==null){
            return 0;
        }
        // 1,2,3;
        int n = 1;
        p = head;
        q = head;
        while(q!=null && n < k ){
            q = q.next;
            n++;
        }
        if (q==null&&n<k){
            return 0;
        }
        while(q.next!=null){
            p=p.next;
            q =q.next;
        }

        return p.val;



    }
}
