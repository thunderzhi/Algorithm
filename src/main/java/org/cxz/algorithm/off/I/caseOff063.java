package org.cxz.algorithm.off.I;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/20 15:23
 */
public class caseOff063 {

    // ver 1 brute
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[] ind = new Integer[n];
        for(int i=0;i<n;i++){
            ind[i] = i;
        }
        Arrays.sort(ind,(o1, o2)->{
            return prices[o1]-prices[o2];
        });
        int max = 0;
        for(int i=0;i<n;i++){
            int r = n-1;
            while(r>=i){
                if(ind[r]<=ind[i]){
                    r--;
                    continue;
                }
                max = Math.max(max,prices[ind[r]]-prices[ind[i]]);
                break;
            }
        }
        return max;
    }
    // ver 2 0ms
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int ans =0;
        for(int i=0;i<n;i++){
            if(min<prices[i]){
                ans = Math.max(ans,prices[i]-min);
            }
            min = Math.min(min,prices[i]);
        }
        return ans;
    }
}
