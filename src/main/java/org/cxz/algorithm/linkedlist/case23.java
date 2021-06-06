package org.cxz.algorithm.linkedlist;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/15 17:41
 */
public class case23 {

    public static void main(String[] args) {


    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        ListNode h = new ListNode(0);
        ListNode p = h;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode x : lists) {
           if (x!=null){
               pq.offer(x);
           }
        }

        while (!pq.isEmpty()){
            ListNode cur = pq.peek();
            p.next = cur;
            pq.poll();
            p = cur;
            if (cur.next!=null){
                pq.offer(cur.next);
            }
        }
        return h.next;
    }
}
