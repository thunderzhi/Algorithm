package org.cxz.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/14 9:53
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
        ListNode t2head = new ListNode(0, null);//big
        ListNode t1head = new ListNode(0, null);//small

        ListNode tail1=t1head,tail2=t2head;
        ListNode p = head;
        while(p.next!=null){
            System.out.println("p is "+p.val);
            if (p.val < x) {
                tail1.next = p;
                System.out.println("p add to first ");
                tail1.next = tail1.next.next;
            }
            else{
                tail2.next =p;
                System.out.println("p add to second ");
                tail2.next = tail2.next.next;
            }
            p = p.next;
        }

        tail1   = t2head.next;
        return t1head.next;
    }
}
