package org.cxz.algorithm.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/28 12:04
 */
public class case528 {
    public static void main(String[] args) {

    }
    public int[] presum;
    public int n;
    public Solution(int[] w) {
        presum = new int[w.length];
        presum[0]=w[0];
        for (int i = 1; i < w.length ; i++) {
            presum[i] =presum[i-1] +w[i];
        }
        n = presum[presum.length-1];

        System.out.println("presum = " +Arrays.toString(presum));
        System.out.println("presum leng = " + presum.length);
    }

    public int pickIndex() {
       
        int ind = new Random().nextInt(Integer.MAX_VALUE)%n;
        int l =0;
        int r = presum.length -1;
        int mid =0;
        while(l<r){
            mid = (r+l)>>1;
            if(presum[mid]<=ind){
                l = mid+1;
            }
            else  {
                r = mid;
            }
        }
        return l;
    }
}
