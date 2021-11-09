package org.cxz.algorithm.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/8 23:57
 */
public class case402 {

    public static void main(String[] args) {

    }
    // myself
    public String removeKdigits(String num, int k) {
        if(num.length()==k){
            return "0";
        }
        Deque<Integer> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<num.length();i++){
            int a =(int)(num.charAt(i)-'0');
            while(!qu.isEmpty()&&a<qu.peekLast()&&k>0){
                qu.pollLast();
                k--;
            }
            qu.offerLast(a);
        }
        while(!qu.isEmpty()&&qu.peekFirst()==0){
            qu.pollFirst();
        }
        if(qu.isEmpty()){
            return "0";
        }
        if(k==0){
            while(!qu.isEmpty()){
                int t = qu.pollFirst();
                sb.append(t);
            }
            return sb.toString().equals("")?"0":sb.toString();
        }
        if(k!=0){
            while(!qu.isEmpty()&&qu.size()>k){
                int t = qu.pollFirst();
                sb.append(t);
            }
            return sb.toString().equals("")?"0":sb.toString();
        }
        return "0";
    }

    public String re(String num,int k){
        Deque<Character> qu = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char d = num.charAt(i);
            while(!qu.isEmpty()&&k>0&&d<qu.peekLast()){
                qu.pollLast();
                k--;
            }
            qu.offerLast(d);
        }
        for (int i = 0; i < k; i++) {
            qu.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        boolean isfirst = true;
        while(!qu.isEmpty()){
            char d = qu.pollFirst();
            if(d=='0'&&isfirst){
                continue;
            }
            sb.append(d);
            isfirst = false;
        }
        return sb.length()==0?"0":sb.toString();
    }
}
