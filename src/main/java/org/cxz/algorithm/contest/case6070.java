package org.cxz.algorithm.contest;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/17 10:43
 */
public class case6070 {

    public static void main(String[] args) {
        String s = new case6070().digitSum("11111222223"
                , 3);
        System.out.println("s = " + s);
        System.out.println("Integer.valueOf  = " + Integer.valueOf("00"));
    }
    //not pass
    public String digitSum(String s, int k) {

        String[] arr = new String[s.length()];
        int cnt = s.length();
        for (int i = 0; i < s.length(); i++) {
            arr[i]=s.charAt(i)+"";
        }
        while(cnt>k){
            String[] tmp = new String[arr.length/2+1];
            int ind =0;
            int p =0;
            int cnt2 = 0;
            while(p<arr.length){
                int q = p;
                int num =0;
                for (int i = q; i <p+k&&i<arr.length ; i++) {
                    num += Integer.valueOf(arr[i]);
                }
                tmp[ind] = String.valueOf(num);
                cnt2 += tmp[ind].length();
                ind++;
            }
            arr = tmp;
            cnt = cnt2;
        }

        return arr[0];
    }
}
