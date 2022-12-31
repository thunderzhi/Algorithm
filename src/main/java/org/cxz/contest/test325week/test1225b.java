package org.cxz.contest.test325week;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/25 10:30
 */
public class test1225a {

    public int closetTarget(String[] words, String target, int startIndex) {
        int ans =-1;
        int n = words.length;
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(words[i].equals(target)){
                ind.add(i);
            }
        }
        if(ind.size()==0) return ans;//-1
        ans = n;
        for (int i = 0; i < ind.size(); i++) {
            int t = ind.get(i);
            System.out.println("t = " + t+" index "+ startIndex);
            if(t>=startIndex){
                int left = t - startIndex;
                int right = startIndex-t+n;
                ans = Math.min(ans,Math.min(left,right));
            }
            else{
                int left = startIndex- t;
//                int right = (t+1)+(n-1-startIndex);
                int right = (t+n-startIndex);
                ans = Math.min(ans,Math.min(left,right));
            }
        }
        return ans;
    }
}
