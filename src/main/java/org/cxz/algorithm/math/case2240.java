package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/2 0:18
 */
public class case2240 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int cnt1 = total/cost1;
        int cnt2 = total/cost2;
        long[] f = new long[total+1];
        f[0] = 1;
        for(int i =0;i<2;i++){
            int c = i==0?cost1:cost2;
            for(int j = 0 ;j<=total;j++){
                f[j] += j>=c?f[j-c]:0;
            }
        }
        long ans = 0;
        for(int i = 0;i<=total;i++){
            ans += f[i];
        }
        return ans;
    }
}
