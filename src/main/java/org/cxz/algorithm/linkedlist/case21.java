package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/15 16:19
 */
public class case21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode h3 = new ListNode(-1);
        ListNode p3 = h3,p1 = list1,p2 = list2;
        while(p1!=null||p2!=null){
            if(p1==null||p2==null){
                p3.next = p1!=null?p1:p2;
                break;
            }
            if(p1.val<=p2.val){
                p3.next = p1;
                p1 = p1.next;
            }
            else{
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
            p3.next = null;
        }
        return h3.next;
    }

}
