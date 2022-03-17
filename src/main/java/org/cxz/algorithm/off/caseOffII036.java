package org.cxz.algorithm.off;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/17 18:01
 */
public class caseOffII036 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> numst = new LinkedList();
        Deque<String> opst = new LinkedList();
        int n = tokens.length;
        int ans =0;
        for(int i = 0;i<n;i++){
            String s = tokens[i];
            if(!isOp(s)){
                numst.push(Integer.valueOf(s));
            }
            else{
                int b = numst.pop();
                int a = numst.pop();
                int tmp = calc(s,a,b);
                numst.push(tmp);
            }
        }
        return numst.peek();
    }

    public int calc(String s,int a,int b){
        int ans =0;
        switch(s){
            case "+":ans = a+b;
                break;
            case "-":ans = a-b;
                break;
            case "*":ans = a*b;
                break;
            case "/":ans = a/b;
                break;
        }
        return ans;
    }

    public boolean isOp(String s){
        if(s.equals("+")||s.equals("-")||
                s.equals("*")||s.equals("/")){
            return true;
        }
        return false;
    }
}
