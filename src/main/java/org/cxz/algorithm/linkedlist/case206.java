package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/7 16:43
 */
public class case206 {
    public static class Node {
        int val;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Node node = new Node(1,null);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        Node head= node;
        while (node!=null){
            System.out.println(" val "+node.val);
            node = node.next;
        }
        System.out.println("------------");
        Node node1 = reverseList(head);
        while (node1!=null){
            System.out.println(" val "+node1.val);
            node1 = node1.next;
        }
    }

    public static Node reverseList(Node head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        Node tail = head.next;
        Node p = reverseList(head.next);
        head.next= tail.next;
        tail.next = head;
        return p;

    }
}

