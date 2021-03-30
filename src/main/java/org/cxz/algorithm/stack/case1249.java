package org.cxz.algorithm.stack;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/21 21:58
 */
public class case1249 {
    public static void main(String[] args) {

    }

    public String minRemoveToMakeValid(String s){
        Stack<Integer> st = new Stack<>();
        boolean[] invalidarr = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(') {
                st.push(i);
                invalidarr[i]=true;
            }
            if (s.charAt(i)==')') {
                if(st.isEmpty()){
                    invalidarr[i]=true;
                }
                else{
                    invalidarr[st.pop()]=false;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!invalidarr[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
