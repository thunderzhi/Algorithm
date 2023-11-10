package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/10 9:24
 */
public class case2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length,m = potions.length;
        Arrays.sort(potions);
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            long s = spells[i];
            long t = (success+s-1)/s;
            int l = 0, r= m, mid = 0;
            while(l<r){
                mid = l+r>>1;
                if(potions[mid]<t) l=mid+1;
                else r = mid;
            }
            ans[i] = m-l;

        }
        return ans;
    }
}
