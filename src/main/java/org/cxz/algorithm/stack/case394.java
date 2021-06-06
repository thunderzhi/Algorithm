package org.cxz.algorithm.stack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/29 22:37
 */
public class case394 {

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        String s1 = new case394().decodeString(s);
        System.out.println("s1 = " + s1);
    }

    public String decodeString(String s) {

        Stack<StringBuffer> strstack = new Stack<>();
        Stack<Integer> numstack = new Stack<>();
        StringBuffer ans = new StringBuffer();

        int num =0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)){
                num= num*10+c-'0';
            }
            else if(c=='['){
                strstack.push(ans);
                numstack.push(num);
                num=0;
                ans=new StringBuffer();

            }
            else if (Character.isAlphabetic(c)){
                ans.append(c);
            }
            else {
                int tmp = numstack.pop();
                StringBuffer sb = strstack.pop();

                for (int i = 0; i < tmp; i++) {
                    sb.append(ans);
                }

                ans =sb;
            }
        }

        return  ans.toString();
    }


}
