package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/22 17:20
 */
public class case1819 {

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int[] f = new int[200005];
        int max =0;
        int t = 0;
        for(int i =0;i<nums.length;i++){
            t = nums[i];
            f[t] = t;
            max = Math.max(max,t);
        }
        int cnt =0;
        for(int i = 1;i<=max;i++){
            int ans =-1;
            for(int j = i;j<=max;j+=i){
                if(f[j]==0){
                    continue;
                }
                if(ans==-1){
                    ans = f[j];
                }
                else{
                    ans = gcd(ans,f[j]);
                }
            }
            if(ans==i){
                cnt+=1;
            }
        }
        return cnt;
    }

    public int gcd(int a ,int b){
        if(b>0){
            return gcd(b,a%b);
        }
        return a;
    }
}
