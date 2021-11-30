package org.cxz.algorithm.bit;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/29 17:59
 */
public class case77b {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0,j=1;i<n;i++,j<<=1){
            map.put(j,i);
        }
        int[] nums= new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i+1;
        }

        for (int i = 0,I=1<<n; i < I ; i++) {
            int val = i;
            if(Integer.bitCount(val)==k){
                List<Integer> arr = new ArrayList<>();
                while(val>0){
                    int ind = val&(-val);
                    arr.add(nums[map.get(ind)]);
                    val&=(val-1);
                }
                ans.add(arr);
            }
        }
        return ans;
    }

}
