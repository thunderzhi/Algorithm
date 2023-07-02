package org.cxz.contest.test351week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/25 10:28
 */
public class test0625a {

    public int gcd(int a,int b){
        if(b>0) return gcd(b,a%b);
        return a;
    }
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int[][] cnt = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = String.valueOf(nums[i]);
            cnt[i][0] = s.charAt(0)-'0';
            cnt[i][1] = s.charAt(s.length()-1)-'0';
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(gcd(cnt[i][0],cnt[j][1])==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
