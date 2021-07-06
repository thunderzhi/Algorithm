package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/5 23:26
 */
public class case876 {
    public static void main(String[] args) {
        
    }

    public ListNode middleNode(ListNode head) {
        int n = 0;
        ListNode p = head;
        ListNode ret = head;
        while (p!=null){
            n++;
            p =p.next;
        }

        int mid = n/2+1;
        int k = 0;
        while (k<mid ){
            k++;
            ret = ret.next;
        }
        return ret;
    }
}
