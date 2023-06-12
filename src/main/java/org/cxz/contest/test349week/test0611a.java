package org.cxz.contest.test348week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/4 10:25
 */
public class test0604a {
    public int minimizedStringLength(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            int ind = s.charAt(i)-'a';
            cnt[ind]++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if(cnt[i]>1){
                ans++;
            }
        }
        return ans;
    }
}
