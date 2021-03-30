package org.cxz.algorithm.dynamic;

import java.text.MessageFormat;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/17 17:41
 */
public class case338 {

    public static void main(String[] args) {
        new case338().countBits(9);
    }
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        arr[0] =0;
        for (int i = 1; i < arr.length ; i++) {
            int b = i&(i-1);
            System.out.println(" i: "+i+" b: "+b);
            String format = MessageFormat.format("arr[{0}]=arr[{1}]+1", i, b);
            System.out.println(format);
            arr[i] = arr[i&(i-1)]+1;
            System.out.println(MessageFormat.format("arr[{0}]={1}",i,arr[i]));
        }
        return arr;
    }
}
