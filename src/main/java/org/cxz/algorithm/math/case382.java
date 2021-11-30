package org.cxz.algorithm.math;

import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/30 9:45
 */
public class case382 {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode h;
    public void Solution(ListNode head) {
        h = head;
    }

    public int getRandom() {
        int res =0;
        int i =0;
        Random r = new Random();
        ListNode p = h;

        while(p!=null){
            int v = r.nextInt(++i);
            if (v<1){
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }
}
