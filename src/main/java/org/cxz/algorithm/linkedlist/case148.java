package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/18 11:17
 */
public class case148 {
    public static void main(String[] args) {

    }
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null ;
        }
        ListNode ret =new ListNode(0);
        ret.next = head;
        int max = head.val;
        int min = head.val;
        int mid = 0;
        ListNode p = head.next;
        while(p!=null){
            if(p.val<min){
                min = p.val;
            }
            if(p.val>max){
                max = p.val;
            }
            p =p.next;
        }
        mid = (max+min)>>1;


        return ret.next = head;


    }
}
