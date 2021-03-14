package org.cxz.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/13 20:35
 */
public class case86 {

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1,4,3,2,5,2));
        ListNode head = NodeUtil.InitLinkList(data);
        partition(head,3);
        ListNode p = head;
        while (p!=null){
            System.out.println("val is "+p.val);
            p = p.next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode bhead = new ListNode(0, null);//small
        ListNode ahead = new ListNode(0, null);//big
        ListNode atail=ahead,btail=bhead;
        ListNode p = head;
        ListNode q = null;
        while(p!=null){
            q = p.next;
            //System.out.println("p is "+p.val);
            if (p.val < x) {
                p.next = atail.next;
                atail.next = p;
                atail = p;
                //System.out.println("p add to first ");

            }
            else{
                p.next = btail.next;
                btail.next = p;
                btail = p;

                //System.out.println("p add to second ");

            }
            p = q;
        }
        atail.next   = bhead.next;
        return ahead.next;
    }
}
