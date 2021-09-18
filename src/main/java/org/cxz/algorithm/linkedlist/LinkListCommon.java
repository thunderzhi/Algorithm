package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/15 15:48
 */
public class LinkListCommon {

    public static int getLinkLength(ListNode head){
        if( head== null){
            return 0;
        }
        ListNode p = head;
        int n = 0;
        while(p!=null){
            p = p.next;
            n++;
        }
        return n;
    }
}
