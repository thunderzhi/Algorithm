package org.cxz.algorithm.linkedlist;

import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/26 11:20
 */
public class case143 {

    public void reorderList(ListNode head) {
        if (head==null){
            return;
        }
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode p  = head;
        while(p!=null){
            queue.add(p);
            p =p.next;
        }
        System.out.println(queue.size());
        ListNode ret = new ListNode(0);
        ret.next = head;
        p =head;
        while(!queue.isEmpty()){

            ListNode node = queue.pollFirst();
            p.next = node;
            p = p.next;
            if (!queue.isEmpty()){
                node = queue.pollLast();
            }
            p.next = node;
            p = p.next;
        }
        p.next=null;

    }

    public boolean check(LinkedList list){
        return list.size()==1?true:false;
    }
}
