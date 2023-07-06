package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/4 13:02
 */
public class case2178 {
    //ver 1 Recommended
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 == 1) return res;
        for (long i = 2; i <= finalSum; i += 2) {
            finalSum -= i;
            if(finalSum <=i) i+=finalSum;
            res.add(i);
        }
        return res;
    }

    //ver2
    public List<Long> maximumEvenSplit2(long finalSum) {
        List<Long> ans =  new ArrayList();
        if((finalSum&1)==1) return ans;
        for(long i=2;i<=finalSum;i+=2){
            ans.add(i);
            finalSum -=i;
        }
        int n = ans.size();
        finalSum += ans.get(n-1);
        ans.set(ans.size()-1,finalSum);
        return ans;
    }

    // calc
    public List<Long> maximumEvenSplit3(long finalSum) {
        List<Long> ans = new ArrayList();
        if(finalSum%2==1) return ans;
        double f = finalSum*1.0+9.0/4.0;
        long k = (long)(Math.sqrt(f)-3.0/2.0);
        if((k+1.5)*(k+1.5)-9.0/4.0>= finalSum*1.0){
            k--;
        }
        long tot =0L,limit = 2*k;
        for(long i = 2;i<=limit;i+=2){
            ans.add(i);
            tot+= i;
        }
        if(finalSum-tot>limit){
            ans.add(finalSum-tot);
        }
        return ans;
    }
}
