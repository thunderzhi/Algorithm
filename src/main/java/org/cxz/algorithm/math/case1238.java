package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/2/23 14:46
 */
public class case1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList();
        ans.add(0);
        for(int i =0;i<n;i++){
            int len = ans.size();
            for(int j =len-1;j>=0;j--){
                int x = ans.get(j);
                ans.add(x|(1<<i));
                int a = x|(1<<i);
            }
        }
        List<Integer> res = new ArrayList();
        int p =0;
        for(int i =0;i<ans.size();i++){
            if(ans.get(i)!=start) continue;
            p = i;
            break;
        }
        int len = ans.size();
        for(int i =0;i<len;i++){
            res.add(ans.get((p+i)%len));
        }
        return res;
    }
}
