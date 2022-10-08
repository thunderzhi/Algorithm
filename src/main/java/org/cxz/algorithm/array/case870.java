package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/8 12:42
 */
public class case870 {

    // sort and two pointer
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length;
        Integer[] ind = new Integer[n];
        int[] ans = new int[n];
        for(int i=0;i<n;i++) {
            ind[i] =i;
        }
        Arrays.sort(ind,(a,b)->{
            return nums2[a]-nums2[b];
        });
        int l =0,r= n-1,p2 = r,p1=r;
        while(l<=r){
            if(nums2[ind[p2]]>=nums1[p1]){
                ans[ind[p2--]] = nums1[l++];
            }
            else{
                ans[ind[p2--]] = nums1[p1--];
                r--;
            }
        }
        return ans;
    }

    // treeset  balance tree 
    public int[] advantageCount2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeSet<Integer> tset = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 1) tset.add(x);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            Integer cur = tset.ceiling(nums2[i] + 1);
            if (cur == null) cur = tset.ceiling(-1);
            ans[i] = cur;
            map.put(cur, map.get(cur) - 1);
            if (map.get(cur) == 0) tset.remove(cur);
        }
        return ans;
    }
}
