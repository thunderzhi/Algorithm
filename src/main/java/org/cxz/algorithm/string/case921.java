package org.cxz.algorithm.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/5 10:34
 */
public class case921 {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Deque<Character> st = new ArrayDeque();
        for(int i =0;i<n;i++){
            char c = s.charAt(i);
            if(!st.isEmpty()&&st.peek()=='('&&c==')'){
                st.pop();
            }
            else {
                st.push(c);
            }
        }
        return st.size();
    }
}
