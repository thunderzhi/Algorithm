package org.cxz.contest.test326week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/1/1 10:30
 */
public class test0101b {

    public int countDigits(int num) {
        int ans =0;
        String s = String.valueOf(num);
        int[] cnt = new int[10];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'0']++;
        }
        for (int i = 0; i <= 9; i++) {
            if(cnt[i]==0) continue;
            if(num%i==0){
                ans+=cnt[i];
            }
        }
        return ans;
    }
}
