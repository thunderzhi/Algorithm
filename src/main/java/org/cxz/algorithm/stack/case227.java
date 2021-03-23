package org.cxz.algorithm.stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/18 14:07
 */
public class case227 {

    public static void main(String[] args) {
         String s = "3+277*2";
         new case227().calculate(s);
    }
    public int level(char c){
        switch (c){
            case '@':return -1;
            case '+':
            case '-':return 1;
            case '*':
            case '/':return 2;
        }
        return 0;
    }
    public int calc(char op,int a,int b){
        switch (op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
        }
        return 0;
    }

    public int calculate(String s) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<Integer>();
        s += "@";

        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (level(s.charAt(i)) == 0) {
                n = n * 10 + (s.charAt(i) - '0');
                continue;
            }
            num.push(n);
            n = 0;
            while (!op.isEmpty() && level(s.charAt(i)) <= level(op.peek())) {
                int b = num.peek();
                num.pop();
                int a = num.peek();
                num.pop();
                num.push(calc(op.peek(), a, b));
                op.pop();
            }
            op.push(s.charAt(i));
        }
        return num.peek();
    }

}
