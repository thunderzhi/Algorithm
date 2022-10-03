package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/3 14:39
 */
public class case1784 {
    
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean ans = true;
        for(int i = 1;i<n;i++){
            if(s.charAt(i)=='1'&&s.charAt(i-1)=='0'){
                return false;
            }
        }
        return ans;
    }
}
