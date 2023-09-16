package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/16 11:48
 */
public class LCP050 {
    public int giveGem(int[] gem, int[][] operations) {
        int max =-1,min = 1001;
        int n = operations.length;
        for(int i =0;i<n;i++){
            int[] op = operations[i];
            int a = op[0], b = op[1];
            int c = gem[a]/2;
            gem[a]-=c;
            gem[b]+=c;
        }
        for(int i = 0;i<gem.length;i++){
            min = Math.min(min,gem[i]);
            max = Math.max(max,gem[i]);
        }
        return max -min;
    }
}
