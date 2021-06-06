package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/5 18:15
 */
public class case203 {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode ret = new ListNode(0);
        ListNode p = head;
        ListNode q = ret;
        if (head==null){
            return null;
        }
        while(p!=null){
            if(p.val==val){

            }
            else{
                q.next = p;
                q = q.next;
            }
            p= p.next;
        }
        if (q!=null&&p==null){
            q.next = null;
        }

        return ret.next;
    }
}
