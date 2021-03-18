package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/17 17:41
 */
public class case338 {

    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        arr[0] =0;
        for (int i = 1; i < arr.length ; i++) {
            arr[i] = arr[i&(i-1)]+1;
        }
        return arr;
    }
}
