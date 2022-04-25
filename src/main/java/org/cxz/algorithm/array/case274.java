package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/22 18:52
 */
public class case274 {
    public static void main(String[] args) {

    }
    //ver 1 sort
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1;
        int n = citations.length;
        //System.out.println("n"+n);
        while(n-h>=0&&citations[n-h]>=h){
            h++;
        }
        h--;
        return h;
    }

    // ver2 count sort
    public int hIndex2(int[] citations) {
        int n = citations.length, tot = 0;
        int[] counter = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}
