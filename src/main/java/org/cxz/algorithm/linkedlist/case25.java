package org.cxz.algorithm.linkedlist;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/8 23:50
 */
public class case25 {

    public static void main(String[] args) {
        ListNode node = new  ListNode(1,null);
        node.next = new  ListNode(2);
        node.next.next = new  ListNode(3);
        node.next.next.next = new  ListNode(4);
        node.next.next.next.next = new  ListNode(5);

        ListNode p = reverseKGroup(node,2);
        while(p!=null){

            System.out.println("p val: "+p.val);
            p= p.next;
        }
    }
   public static ListNode reverseN(ListNode head,int n){
        ListNode p =head;
        int count  = n-1;
        while(count>0&&p!=null){
            p= p.next;
            count--;
        }
        if(p==null){ return head;}
        return realreverseN(head,n);
   }

    public static ListNode realreverseN(ListNode head,int n){
        if(n==1){return  head;}
        ListNode tail = head.next, p = realreverseN(head.next,n-1);
        head.next=tail.next;
        tail.next =head;
        return p;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode ret = new ListNode(0, head),p=ret,q=p.next;
        while ((p.next=reverseN(q,k))!=q){
            p =q;
            q =p.next;
        }
        return ret.next;
    }
}
