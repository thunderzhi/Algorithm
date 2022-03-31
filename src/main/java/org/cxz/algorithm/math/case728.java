package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/31 16:01
 */
public class case728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for(int i = left;i<=right;i++){
            if(!check(i)) continue;
            ans.add(i);
        }
        return ans;
    }
    public boolean check(int num){
        int n = num;
        while(n>0){
            int rest = n%10;
            n /= 10;
            if(rest==0||(num%rest!=0)) return false;

        }
        return true;
    }
}
