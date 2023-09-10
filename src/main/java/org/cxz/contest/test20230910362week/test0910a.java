package org.cxz.contest.test20230910362week;

import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/10 10:20
 */
public class test0910a {
    public int numberOfPoints(List<List<Integer>> nums) {
        int n = nums.size();
        if(n==1){
            int l = nums.get(0).get(0);
            int r = nums.get(0).get(1);
            return r-l+1;
        }

        Collections.sort(nums,(a,b)->{
            return a.get(0)-b.get(0);
        });
        System.out.println("nums = " + nums.toString());
        int ans = 0,l =nums.get(0).get(0),r=nums.get(0).get(1);

        for (int i = 1; i < n; i++) {
            List<Integer> cur = nums.get(i);
            if(cur.get(0)>r){
                ans += r-l+1;
                l = cur.get(0);
                r = cur.get(1);
            }
            else{
                r =Math.max(r,cur.get(1)) ;
            }
            if(i==n) ans+= r-l+1;
        }
        return ans;
    }
}
