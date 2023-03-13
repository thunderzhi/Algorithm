package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/2/25 11:48
 */
public class case1247 {

    public int minimumSwap(String s1, String s2) {
        int cntxy=0,cntyx=0,n = s1.length();
        for(int i =0;i<n;i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1=='x'&&c2=='y') cntxy++;
            if(c1=='y'&&c2=='x') cntyx++;
        }
        if((cntxy+cntyx)%2==1) return -1;
        int ans =0;
        ans += cntxy/2;
        ans += cntyx/2;
        ans+=  (cntxy%2+cntyx%2);
        return ans;
    } 
}

