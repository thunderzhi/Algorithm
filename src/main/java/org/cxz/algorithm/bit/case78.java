package org.cxz.algorithm.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/20 22:58
 */
public class case78 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets2(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0,j=1; i < n; i++,j<<=1) {
            map.put(j,i);
        }

        for (int i = 0,I = (1<<n);i<I;i++){
            List<Integer> arr = new ArrayList<>();
            int val = i;
            while(val>0) {
                int ind = val & (-val);
                System.out.println("val= "+val+" last ind = " + ind);
                arr.add(nums[map.get(ind)]);
                val &= (val - 1);
            }
            ans.add(arr);
        }
        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0,I = (1<<n);i<I;i++){
            List<Integer> arr = new ArrayList<>();
            for (int j =0;j<n;j++){
                if((i&(1<<j))!=0){
                    arr.add(nums[j]);
                }
            }
            ans.add(arr);
        }
        return ans;
    }



}
