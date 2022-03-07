package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/7 17:13
 */
public class case1863 {

    public int ans;
    // ver1 dfs
    public int subsetXORSum1(int[] nums) {
        dfs(nums,0,0);
        return ans;
    }

    public void dfs(int[] nums,int ind,int val){
        if(ind==nums.length){
            ans += val;
            return;
        }

        dfs(nums,ind+1,val);

        val^=nums[ind];
        dfs(nums,ind+1,val);
        return;
    }


    // ver 2 diedai
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i=0;i<(1<<n);i++){
            int sum = 0;
            for(int j = 0;j<n;j++){
                if((i&(1<<j))!=0){
                    sum ^=nums[j];
                }
            }
            ans +=sum;
        }
        return ans;
    }
}
