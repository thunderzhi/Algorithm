package org.cxz.algorithm.stack;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/21 12:09
 */
public class case844 {
    public static void main(String[] args) {
        boolean b = new case844().backspaceCompare("a#c", "b");
        System.out.print( b);
    }
    public void transform(String str , Stack<Character> s){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('#'==c&&!s.isEmpty()){
                s.pop();
            }
            else if(c!='#'){
                s.push(c);
            }
        }
        return;
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();
        Stack<Character> t = new Stack<>();
        transform(S,s);
        transform(T,t);
        if (s.size()!=t.size()){
            return  false;
        }
        while(!s.isEmpty()&&!t.isEmpty()){
            if (!s.peek().equals(t.peek())) {
                return false;
            }
            s.pop();t.pop();
        }
        return true;
    }
}
