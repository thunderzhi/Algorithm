package org.cxz.algorithm.contest;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/16 22:51
 */
public class case6061 {
    //pass
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int m = total/cost1;
        int n = total/cost2;
        long ans = 0;
        for (int i = 0; i <=m ; i++) {
            if(total<cost1*i) break;
            int cnt2 = (total- cost1*i)/cost2+1;
            ans+=cnt2;
        }
        return ans;
    }
}
