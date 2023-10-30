package org.cxz.contest.test2023116dweek;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/28 21:42
 */
public class test1028a {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        long mod = (long)1e9+7;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j <n ; j++) {
                long m = (long)getcnt(i,j,nums);
                m = m*m%mod;
                ans = (ans+m)%mod;
            }
        }
        return (int)ans;
    }
    public int getcnt(int l,int r ,List<Integer> arr){
        int[] map = new int[101];
        for(int i = l;i<=r;i++){
            map[arr.get(i)]++;
        }
        int s = 0;
        for (int i = 0; i < 101; i++) {
            if(map[i]==0) continue;
            s++;
        }
        return s;
    }
}
