package org.cxz.contest.test20231210375week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/12/10 10:20
 */
public class test1210 {
    public int countTestedDevices(int[] batteryPercentages) {
        int cnt =0,ans=0,n = batteryPercentages.length;
        int[] bp = batteryPercentages;
        for (int i = 0; i < n; i++) {
            if(bp[i]-cnt>0){
                ans++;
                cnt++;
            }
        }
        return ans;
    }


    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<>();
        int n = variables.length;
        int[][] var = variables;
        for (int i = 0; i < n; i++) {
            int a = var[i][0],b=var[i][1],c=var[i][2],m=var[i][3];
            int t = fast(a,b,10);
            int s = fast(t,c,m);
            if(s==target) ans.add(i);
        }
        return ans;

    }
    public int fast(int x,int y,int mod){
        int res = 1;
        while(y>0){
            if((y&1)==1) res = ((res%mod) * (x%mod))%mod;
            x = ((x%mod)*(x%mod))%mod;
            y>>>=1;
        }
        return res;
    }

    public long countSubarrays(int[] nums, int k) {
        int max = 0,n = nums.length;
        for (int x:nums) {
            max = Math.max(max,x);
        }
        Map<Integer,Long>[] f = new HashMap[n+1];
        for (int i = 0; i <= n; i++) {
            f[i] = new HashMap<>();

        }
        f[1].put(nums[0]==max?1:0,1L);
        long tot = 0L;
        for (int i = 2; i <= n; i++) {
            // f[i][j]  =  f[i-1][j-1] , if  nums[i-1]==max
            // f[i][j]  =  f[i-1][j] +1 , if  nums[i-1]!=max
            long s = 0L;
            if(nums[i-1]==max){
                f[i].put(1,1L);
                s+=1;
                for(int key :f[i-1].keySet()){
                    if(key+1<k){
                        Long a = f[i - 1].get(key);
                        f[i].put(key+1,a);
                        s+=a;
                        //System.out.println(" i "+ i+ " a = " + a+" max "+max + " key "+key+ " tot "+tot);
                    }
                }
            }
            else{
                f[i].put(0,1L);
                s+=1;
                for(int key :f[i-1].keySet()){
                    if(key<k){
                        Long a = f[i - 1].get(key);

                        f[i].put(key,f[i].getOrDefault(key,0L)+a);
                        s+=a;
                        //System.out.println(" i "+ i+ " a = " + a+  " key "+key+ " tot "+tot);

                    }
                }
            }
            tot+=s;
        }
        // 1 2 3 4 5 ..n
        // n-1 + n-2+.... 1+0
        long sum = n*(n-1)/2;
        return sum-tot;


    }
}
