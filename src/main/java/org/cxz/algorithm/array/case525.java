package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/4 0:00
 */
public class case525 {

    //ver 1 hash
    public int findMaxLength1(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int[] sum = new int[n+1];
        Map<Integer,Integer> map = new HashMap();
        map.put(0,0);
        for(int i = 0;i<n;i++){
            sum[i+1] = sum[i]+(nums[i]==1?1:-1);
            if(!map.containsKey(sum[i+1])) map.put(sum[i+1],i+1);
        }
        int ans =0;
        for(int i= n;i>=0;i--){
            if(!map.containsKey(sum[i])) continue;
            if(map.get(sum[i])!=i){
                ans = Math.max(ans,i-map.get(sum[i]));
            }
        }
        return ans;
    }


    //ver 3 Array imitate Hash
    public int findMaxLength3(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        int ans = 0;
        int[] hash = new int[2 * n + 1];
        Arrays.fill(hash, -1);
        for (int i = 2; i <= n; i++) {
            if (hash[sum[i - 2] + n] == -1) hash[sum[i - 2] + n] = i - 2;
            if (hash[sum[i] + n] != -1) ans = Math.max(ans, i - hash[sum[i] + n]);
        }
        return ans;

    }
}
