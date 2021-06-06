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

        //return sortList(head,null); quick sort
        ListNode p = head;
        int n =0;
        while(p!=null){
            p =p.next;
            n++;
        }
        System.out.println("n = " + n);
        return sortList(head ,n );
    }


    //region quick sort merge
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
  //
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
    //endregion

    // guibin
    public ListNode sortList(ListNode head,int n){
        if(head==null||head.next==null){
            return head;//直到拆到一个node
        }
        int l = n>>1;int r = n-l;

        ListNode lp = head,rp =head,p ;
        for (int i = 1; i < l ; i++) {
            rp = rp.next;
        }//找到r的 prev
        p = rp;
        rp = rp.next;//rp is r head
        p.next = null;//split list
        lp= sortList(lp,l);
        rp= sortList(rp,r);

        ListNode ret = new ListNode(0);
        p = ret;
        while(lp!=null||rp!=null){
            if((rp==null)||(lp!=null&&lp.val<=rp.val)){
                p.next = lp;
                lp = lp.next;

            }
            else {
                p.next = rp;
                rp = rp.next;
            }
            p =p.next;
        }
        return ret.next;
    }

}
