package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/9 20:43
 */
public class case2121 {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        Integer[] ind = new Integer[n];
        for (int i = 0; i < n; i++) {
            ind[i] = i;
        }

        Arrays.sort(ind,(o1, o2)->{
            if(arr[o1]!=arr[o2]) return arr[o1]-arr[o2];
            return o1-o2;
        });
        long[] ret = new long[n];
        for (int i = 0, j; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && arr[ind[i]] == arr[ind[j + 1]]) j++;
            long pre_sum = 0, next_sum = 0;
            for (int k = i; k <= j; k++) next_sum += ind[k];
            for (int k = i; k <= j; k++) {
                next_sum -= ind[k];
                ret[ind[k]] = (long) (2 * k - i - j) * ind[k] - pre_sum + next_sum;
                pre_sum += ind[k];
            }
        }
        return ret;
    }
}
