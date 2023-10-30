package org.cxz.contest.test2023116dweek;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/28 21:42
 */
public class test1028c {
    int n,max;
    List<Integer> arr;
    Integer[][][] memo;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Collections.sort(nums);
        if(nums.get(0)>target) return -1;
        n = nums.size();
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += nums.get(i);
        }
        if(s<target) return -1;
        arr = nums;
        max =-1;
        memo = new Integer[n+1][target+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <=target ; j++) {
                Arrays.fill(memo[i][j],-1);
            }
        }
        int res = dfs(0,target,0);
        if(res<1001&&max<res) max = res;
        return max;
    }
    public int dfs(int idx ,int t,int cnt){
        if(idx>=0&&memo[idx][t][cnt]!=-1) return memo[idx][t][cnt];
        if(idx==n){
            // if t!=0 not find,
            //if t==0
            if(t==0) max = Math.max(max,cnt);
            return t!=0?1001:cnt;
        }
        // -1<=idx<n;
        //not chose

        int res1 = dfs(idx+1,t,cnt);

        //chose
        int res2=1002;
        if(t>=arr.get(idx)){
            res2 = dfs(idx+1,t-arr.get(idx),cnt+1);
        }
        int res = Math.min(res1,res2);
        if(idx>=0) memo[idx][t][cnt]= res;
        return res;
    }
}
