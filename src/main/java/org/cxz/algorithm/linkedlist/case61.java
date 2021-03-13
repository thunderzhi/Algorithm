package org.cxz.algorithm.linkedlist;


import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/9 0:22
 */
public class case61 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int n = 1;
        ListNode p = head;//p指向head
        while (p.next!=null){
            p = p.next;
            n++;
        }//n 表长度

        p.next = head;
        k%=n;
        k = n-k;//p从head向后移动n-k
        while (k>0){
            k--;
            p=p.next;
        }
        head =p.next;
        p.next =null;
        return head;
    }
}
