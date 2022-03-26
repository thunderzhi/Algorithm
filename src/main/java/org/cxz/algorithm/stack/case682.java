package org.cxz.algorithm.stack;

import javax.lang.model.element.VariableElement;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/21 11:02
 */
public class case682 {

    public static void main(String[] args) {
        String[] arr = {"5","2","C","D","+"};
        int calpoint = calpoint(arr);
        System.out.println(calpoint);
    }

    public static int calpoint(String[] ops){
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < ops.length; i++){
            if(ops[i].equals("+")){
                Integer a = s.pop();
                int b = s.peek();
                s.push(a);
                s.push(a+b);
            }
            else if(ops[i].equals("D")){
                Integer peek = s.peek();
                s.push(peek*2);
            }
            else if(ops[i].equals("C")){
                s.pop();
            }
            else{
                s.push(Integer.valueOf(ops[i]));
            }
        }
        int score = 0;
        while (!s.isEmpty()){
            score+= s.pop();
        }
        return  score;

    }

    //ver 2 
    public int calPoints2(String[] ops) {
        int ans =0;
        int n = ops.length;
        //Deque<String> st = new LinkedList();
        Deque<Integer> num = new LinkedList();
        for(int i=0;i<n;i++){
            ans = calc(ops[i],num,ans);
        }
        return ans;
    }

    public int calc(String s ,Deque<Integer> num,int ans){
        switch (s){
            case "+":{
                int a = num.pop();
                int b = num.pop();
                num.push(b);
                num.push(a);
                num.push(a+b);
                ans +=(a+b);
                break;
            }
            case "C":{
                int a = num.pop();
                ans -= a;
                break;
            }
            case "D":{
                int a = num.peek()<<1;
                ans +=a;
                num.push(a);
                break;
            }
            default:{
                int a = Integer.valueOf(s);
                num.push(a);
                ans += a;
            }
        }
        return ans;
    }
}
