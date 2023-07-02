package org.cxz.contest.test352week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/2 10:31
 */
public class test0702c {
        public long continuousSubarrays(int[] nums) {
            int l = 0,r=-1,n = nums.length;
            int max = 0,min = 1<<30;
            long ans =0;
            TreeMap<Integer,Integer> tm = new TreeMap();
            while(r<n){
                r++;
                if(r==n) break;
                tm.put(nums[r],tm.getOrDefault(nums[r],0)+1);
                //tm.lastKey() - tm.firstKey()
                while(l<r&&(tm.lastKey() - tm.firstKey())>2){
                    int left = nums[l];
                    //del left in map
                    if(tm.get(left)==1){
                        tm.remove(left);
                    }
                    else{
                        tm.put(left,tm.get(left)-1);
                    }
                    l++;
                }
                ans += r-l+1;
            }
            return ans;
        } 
}
