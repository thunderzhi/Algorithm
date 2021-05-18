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
        ListNode t = h;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            while(list!=null){
                //if(list.val)   to be continue.............
                pq.offer(list);
                list= list.next;
            }
        }
        while (pq.size()>0){
            ListNode poll = pq.poll();
            t.next = poll;
            t = t.next;
        }
        return h.next;
    }
}
