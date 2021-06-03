package org.cxz.algorithm.linkedlist;

import javafx.collections.transformation.SortedList;

import java.awt.*;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/18 11:17
 */
public class case148 {
    public static void main(String[] args) {
        //[4,2,1,3]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next =new ListNode(1);
        head.next.next.next =new ListNode(3);
        ListNode listNode = new case148().sortList(head);


    }
    public ListNode sortList(ListNode head) {
        return sortList(head,null);
    }


    public ListNode sortList(ListNode head,ListNode tail) {

        if(head==null){
            return null ;
        }
        // System.out.println("head.val = " + head.val);
        if(head.next== tail){
            head.next =null;
            return head;
        }
        ListNode ret =new ListNode(0);
        ListNode slow =head;
        ListNode fast =head;
        while(fast!=tail&&fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode left = sortList(head,mid);
        ListNode right = sortList(mid,tail);

        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right ){
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while(left!=null&&right!=null){
            if (left.val<right.val){
                p.next = left;
                left = left.next;
                p = p.next;
            }
            else{
                p.next = right;
                right = right.next;
                p = p.next;
            }
        }
        p.next = left!=null?left: right;
        return ret.next;
    }
}
