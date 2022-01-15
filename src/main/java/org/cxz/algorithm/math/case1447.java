package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/15 16:32
 */
public class case1447 {

    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList();
        for(int i=1;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(gcd(i,j)!=1){
                    continue;
                }
                ans.add(i+"/"+j);
            }
        }
        return ans;
    }

    public int gcd(int a,int b){
        if(b>0){
            return gcd(b,a%b);
        }
        return a;
    }

}
