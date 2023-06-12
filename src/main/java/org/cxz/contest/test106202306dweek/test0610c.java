package org.cxz.contest.test106202306dweek;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/27 22:38
 */
public class test0610b {
    public boolean check(String s,int i,int j){
        int cnt = 0;
        for(int p = i;p<=j;p++){
            if(p+1<=j&&s.charAt(p)==s.charAt(p+1)){
                cnt++;
            }
            if(cnt>1)return false;
        }
        return true;
    }
    public int longestSemiRepetitiveSubstring(String s) {

        int ans = -1;
        for(int len = s.length();len>0;len--){
            // s.length-1-i+1=len
            for (int i = 0; i+len <=s.length() ; i++) {
                if(check(s,i,i+len-1)){
                    ans = len;
                    break;
                }
            }
            if(ans!=-1) break;
        }
        return  ans;
    }
}
