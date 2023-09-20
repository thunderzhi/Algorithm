package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/20 22:25
 */
public class LCP006 { 
    public int minCount(int[] coins) {
        int ans = 0;
        for(int c :coins){
            ans += (c+1)/2;
        }
        return ans;
    }
}
