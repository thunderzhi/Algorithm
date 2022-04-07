package org.cxz.algorithm.off.I;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/6 17:11
 */
public class caseOff057II {

    public int[][] findContinuousSequence(int target) {
        int sum =0;
        int n = target/2+1;
        int l =1,r =1;
        List<List<Integer>> arr = new ArrayList();
        while(l<n){
            if(sum == target){
                List<Integer> tmp = new ArrayList();
                for(int i = l ;i<r;i++){
                    tmp.add(i);
                }
                arr.add(tmp);
                sum +=r;
                r++;
            }
            else if(sum<target){
                sum += r;
                r++;
            }
            else{
                sum -=l;
                l++;
            }
        }
        int[][] ans = new int[arr.size()][];
        for(int i = 0;i<arr.size();i++){
            ans[i] = arr.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return ans;
    }
}
