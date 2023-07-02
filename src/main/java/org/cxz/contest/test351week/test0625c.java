package org.cxz.contest.test351week;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/25 10:28
 */
public class test0625c {

    public int numberOfGoodSubarraySplits(int[] nums) {
        // f[i] 以i为结尾的可以划分good 的数量
        //f[i]==-1
        //f[i]== 0 no good
        // 0 1 2 3 4
        //[0,1,0,0,1]
        // f[0] = 0 ,
        // f[1] =1 {0,1}
        // f[2] = 1 {0,1,0}   not {0}{1}{0}
        //f[3] = 1
        //
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            if(nums[i]==0) continue;
            list.add(i);
        }
        if(list.size()==0) return 0;
        int ans= 1;
        int mod = (int)1e9+7;
        for (int i = 0; i+1 < list.size(); i++) {
            int c  = list.get(i+1) - list.get(i);
            ans = ((ans%mod) * (c%mod))%mod;
        }
        return ans;




    }
}
