package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/30 12:17
 */
public class case1574 {
    //ver1 ON space O1
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length,q = n-1, ans = n+1;
        while (q>0 && arr[q - 1] <= arr[q]) --q;
        if (q == 0) return 0;
        ans = q;
        for (int i = 0; i < n; i++) {
            if (i>0 && arr[i] < arr[i - 1]) break;
            while (q <= i || (q < n && arr[q] < arr[i])) q += 1;
            ans = Math.min(q - i - 1, ans);
        }
        return ans;
    }
}
