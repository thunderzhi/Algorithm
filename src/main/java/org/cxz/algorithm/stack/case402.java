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

    public String removeKdigits(String num, int k) {
        Deque<Integer> qu = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<num.length();i++){
            int a =(int)(num.charAt(i)-'0');
            while(!qu.isEmpty()&&a<qu.peekLast()){
                qu.pollLast();
                k--;
            }
            if(k==0){

                while(!qu.isEmpty()&&qu.peekFirst()==0){
                    qu.pollFirst();
                }
                while(!qu.isEmpty()){
                    int t = qu.pollFirst();
                    if(t==0&&sb.length()==0){
                        continue;
                    }
                    if(t>=0){
                        sb.append(t.toString());
                    }
                }
                sb.append(num.substring(i,num.length()));
                return sb.toString();
            }
            qu.offerLast(a);

        }

        if(k!=0){
            while(!qu.isEmpty()){

            }
        }
    }
}
