package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/8 20:46
 */
public class case92 {
     

    public static void main(String[] args) {
        ListNode node = new ListNode(9,null);
        node.next = new ListNode(7);
        node.next.next = new  ListNode(2);
        node.next.next.next = new  ListNode(6);
        node.next.next.next.next = new  ListNode(4);
        node.next.next.next.next.next = new  ListNode(3);
        node.next.next.next.next.next.next = new  ListNode(6);

        //left 3  right 6

        reverseBetween(node,3,6 );
        while(node.next!=null){
            System.out.println("node = "+ node.val);
            node =node.next;
        }

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode vitrualnode = new ListNode(0, head);

        ListNode pre = vitrualnode;//
        int move = left;
        while(move>1){
            pre= pre.next;
            move--;
        }
        pre.next = reversN(pre.next, right - left + 1);

        return vitrualnode;
    }

    //reverse N node
    public static ListNode reversN(ListNode head,int n){
        if(n ==1){
            return head;
        }
        ListNode tail = head.next;
        ListNode p = reversN(head.next,n-1);
        head.next= tail.next;
        tail.next = head;
        return p;
    }
}
