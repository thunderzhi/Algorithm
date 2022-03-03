package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 12:13
 */
public class case409 {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for(char c: s.toCharArray()){
            cnt[c]++;
        }
        int ans =0;
        for(int i:cnt){
            if(i>0){
                ans += i%2==0?i:i-1;
            }
        }
        return ans == s.length()? ans: ans+1;
    }
}
