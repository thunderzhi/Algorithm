package org.cxz.algorithm.linkedlist;

import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/24 23:12
 */
public class case0203 {

    public LinkedList<ListNode> q1;
    public LinkedList<ListNode> q2;


    public void deleteNode(ListNode node) {
        if(node == null){
            return;
        }
        ListNode p = node;
        ListNode q = node.next;
        node.val = q.val;

        p.next = q.next;
        q.next =null;






        System.out.println(node.val);
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        p = node;
        while(p!=null){
            q2.offerLast(p);
            p=p.next;
        }
        int cnt = q2.size();
        int k =0;
        if(cnt%2==0){
            k= cnt/2;
        }
        else{
            k=cnt/2+1;
        }
        while(k>0){
            q1.offerLast(q2.pollFirst());
            k--;
        }
        q1.pollLast();
        q1.peekLast().next = q2.peekFirst();

    }
}
