package org.cxz.algorithm.math;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/28 10:21
 */
public class case504 {
    public static void main(String[] args) {

    }


    public String convertToBase7(int num) {
        if (num==0){
            return "0";
        }
        boolean negaitive = num<0;
        num = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        List<Integer> ret = new ArrayList<>();
        while(num>0){
            int t = num%7;
            ret.add(t);
            num = num/7;
        }
        Collections.reverse(ret);
        if(negaitive){
            sb.append("-");
        }
        for (Integer a : ret){
            sb.append(a);
        }
        return sb.toString();
    }
}
