package org.cxz.algorithm.linkedlist;

import java.util.ArrayList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/14 9:54
 */
public class NodeUtil {

    public static ListNode InitLinkList(ArrayList<Integer> arr){
        if (arr==null||arr.size()<=0){
            return null;
        }
        ListNode head = null;
        head =new ListNode(0,null) ;
        ListNode p = head;
        for (int t : arr) {
            p.next = new ListNode(t,null);
            p = p.next;
        }
        return head.next;
    }



}
