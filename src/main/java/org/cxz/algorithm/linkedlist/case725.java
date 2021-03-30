package org.cxz.algorithm.linkedlist;

import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/26 17:20
 */
public class case725 {

    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode p = root;
        while(p!=null){
            length++;
            p= p.next;
        }
        if(root==null){
            ListNode[] res = new ListNode[]{};
            return res;
        }
        ListNode right = null;
        ListNode left = null;
        ListNode[] res = new ListNode[k];
        System.out.println(length);
        for (int i = 0,len; i <k ; i++) {
            res[i] = root;
            len = i<length%k?length/k +1:length/k;
            right = root;
            while (--len > 0) {
                right = right.next;
            }
            left = null;
            if (right != null) {
                left = right.next;
                right.next = null;
            }
            root = left;
        }


        for (int i = 0,len; i <k ; i++) {
            res[i] = root;
            len = i<length%k?length/k +1:length/k;

            right = root;

            while(len>0){
                right = right.next;
                len--;
            }
            left = null;
            if(right!=null){
                left = right.next;
                right.next=null;
            }
            root = left;
        }

        return res;
    }




    public void out(ListNode h){
        ListNode p = h;
        while(p!=null){
            System.out.print(p.val);
            p=p.next;
        }
        System.out.println("-----");
    }
}
