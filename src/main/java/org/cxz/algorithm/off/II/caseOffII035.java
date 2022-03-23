package org.cxz.algorithm.off.II;

import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/17 10:41
 */
public class caseOffII035 {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int n = timePoints.size();
        int ans =gettime(timePoints.get(0))+24*60-gettime(timePoints.get(n-1));
        for(int i =1;i<n;i++){
            ans = Math.min(ans,gettime(timePoints.get(i))-gettime(timePoints.get(i-1)));
        }
        return ans;
    }
    public int gettime(String s){
        return (s.charAt(0)-'0')*10*60+(s.charAt(1)-'0')*60+
                (s.charAt(3)-'0')*10+ (s.charAt(4)-'0');
    }
}
