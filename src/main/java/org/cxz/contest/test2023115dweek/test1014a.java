package org.cxz.contest.test2023115dweek;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/14 22:29
 */
public class test1014a {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> list = new ArrayList();
        List<Integer> ans = new ArrayList();
        int k = 0,n = words.size();
        for (int i = 0; i < n; i++) {
            String s = words.get(i);
            if(s.charAt(0)=='p'){
                int idx = list.size()-k-1;
                if(idx<0) ans.add(-1);
                else ans.add(list.get(idx));
                k++;
            }
            else{
                int v = Integer.parseInt(s);
                list.add(v);
                k=0;
            }
        }
        return ans;
    }
}
