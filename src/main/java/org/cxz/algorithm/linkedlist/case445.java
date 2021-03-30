package org.cxz.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/25 17:44
 */
public class case445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        Stack<Integer> num1 = new Stack<>();
        Stack<Integer> num2 = new Stack<>();
        ListNode p = l1;
        ListNode q = l2;
        while(p!=null){
            num1.push(p.val);
            p = p.next;
        }
        while(q!=null){
            num2.push(q.val);
            q = q.next;
        }

        int flag =0;
        Stack<ListNode> sum = new Stack<>();
        while (!num1.empty()||!num2.empty()){
            //System.out.println("num1 "+num1.peek()+" num2 "+num2.peek());
            int a =0;
            int b =0;
            if(!num1.empty()){
                a = num1.peek();
                num1.pop();
            }
            if(!num2.empty()){
                b = num2.peek();
                num2.pop();
            }
            int t = a+b + flag ;
            if (t>=10){
                flag = 1;
                t-=10;
            }
            else{
                flag = 0;
            }
            System.out.println("push " +t);
            sum.push(new ListNode(t));
        }

        if (flag==1){
            sum.push(new ListNode(1));
        }


        ListNode head = new ListNode(0);
        head.next =null;
        p =head;

        while (!sum.empty()){
            q = sum.peek();
            System.out.println("peek " +sum.peek().val);
            p.next = q;
            p = p.next;
            sum.pop();
        }
        return head.next;
    }
}
