package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/7 16:43
 */
public class case206 {


    public static void main(String[] args) {
        ListNode node = new ListNode(1,null);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        int linkLength = LinkListCommon.getLinkLength(node);
        System.out.println("linkLength = " + linkLength);
        ListNode node2 = new ListNode(1,null);
          linkLength = LinkListCommon.getLinkLength(node2);
        System.out.println("linkLength = " + linkLength);
        ListNode head= node;
//        while (node!=null){
//            System.out.println(" val "+node.val);
//            node = node.next;
//        }
        System.out.println("------------");
        ListNode node1 = reverseList(head);
        while (node1!=null){
            System.out.println(" val "+node1.val);
            node1 = node1.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode tail = head.next;
        ListNode p = reverseList(head.next);
        head.next= tail.next;
        tail.next = head;
        return p;
    }
}

