package org.cxz.contest.test2023112dweek;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/2 22:16
 */
public class test0902c {

    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0,sum =0;
        int n = nums.size();
        int l = 0 , r = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r<n){
            int x = nums.get(r);
            map.put(x,map.getOrDefault(x,0)+1);
            sum += x;
            while(r-l+1>k){
                int y = nums.get(l);
                int cnt = map.get(y);
                sum -= y;
                cnt--;
                if(cnt==0){
                    map.remove(y);
                }
                else{
                    map.put(y,cnt);
                }

                l++;
            }
            if(r-l+1==k&&map.size()>=m){
                ans = Math.max(ans,sum);
            }
            r++;
        }
        return ans;
    }
}
