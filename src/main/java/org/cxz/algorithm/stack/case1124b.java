package org.cxz.algorithm.stack;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/23 15:39
 */
public class case1124b {
    public static void main(String[] args) {
        int[] ints = {9, 9, 6, 0, 6, 6, 9};
        //1,1,-1,-1,-1,-1,1
        int i = new case1124b().longestWPI(ints);

    }

    public int longestWPI(int[] hours) {
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        for (int i = 0; i < hours.length; i++){
            if (hours[i] > 8) {
                sum++;
            } else {
                sum--;
            }
            if (sum > 0) {
                res = i + 1;
            }
            else {
                if (!sumToIndex.containsKey(sum)){
                    sumToIndex.put(sum, i);
                }
                if (sumToIndex.containsKey(sum - 1)) {
                    res = Math.max(res, i - sumToIndex.get(sum - 1));
                }
            }
        }
        return res;
    }
 }


