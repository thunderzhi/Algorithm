package org.cxz.contest.test349week;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/4 10:25
 */
public class test0618c {

    int ans = 0,mod = (int)1e9+7,u=0;
    int[] arr;
    int[][] memo;
    public int specialPerm(int[] nums) {
        //nums[i] % nums[i+1] == 0
        // a % b ==0  1. a==0  2 a = kb
        int n = nums.length;
        arr = nums;
        u = (1<<n)-1;
        memo = new int[n+1][u+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i],-1);
        }
        for (int i = 0; i < n; i++) {
            ans = (ans+ dfs(i,1<<i))%mod;
        }
        return ans;
    }


    //以pre开头，在剩余的元素中符合条件的构成的排列。can = u^used

    // 1 used  0 not used
    public int dfs(int preidx,int mask){
        if(memo[preidx][mask]>=0) return memo[preidx][mask];
        if(mask==u){
            return memo[preidx][mask]=1;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(((mask>>i)&1)!=0) continue;
            if(preidx==-1){
                res = (res+ dfs(i,mask|(1<<i)))%mod;
            }
            else if(arr[preidx]%arr[i]==0||arr[i]%arr[preidx]==0){
                res = (res+ dfs(i,mask|(1<<i)))%mod;
            }
        }
        return memo[preidx][mask]=res;
    }

//    public void dfs(int cnt,int mask,int pre){
//        if(cnt==0){
//            ans= (ans+1)%mod;
//            return;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if(((mask>>i)&1)!=0) continue;
//            if(pre%arr[i]==0||arr[i]%pre==0){
//                dfs(cnt-1,mask|(1<<i),arr[i]);
//            }
//        }
//        return;
//    }
}
