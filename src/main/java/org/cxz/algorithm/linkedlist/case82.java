package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/9 0:58
 */
public class case82 {
    public static void main(String[] args) {
        ListNode node = new  ListNode(1,null);
        node.next = new  ListNode(2);
        node.next.next = new  ListNode(3);
        node.next.next.next = new  ListNode(3);
        node.next.next.next.next = new  ListNode(4);
        node.next.next.next.next.next = new  ListNode(4);
        node.next.next.next.next.next.next = new  ListNode(5);

        ListNode node2 = new  ListNode(1,null);
        node2.next = new  ListNode(1);
        ListNode p = deleteDuplicates(node2);
        while (p!=null){
            System.out.println("val is "+p.val);
            p= p.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ret = new ListNode(0, head);
        ListNode p = ret;
        ListNode q ;
        while(p.next!=null){
            if(p.next.next!=null && p.next.val==p.next.next.val){
                q = p.next.next;
                while(q!=null&&q.next!=null&&q.val==q.next.val){
                    q =q.next;
                }
                p.next =q.next;
            }
            else{
                p = p.next;
            }
        }
        return ret.next;
    }
}
