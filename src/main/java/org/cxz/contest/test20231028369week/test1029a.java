package org.cxz.contest.test20231028369week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/28 21:44
 */
public class test1029a {
    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[31];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j <31 ; j++) {
                if((x&(1<<j))==0) continue;
                cnt[j]++;
            }
        }
        int kor = 0;
        for (int i = 0; i < 31; i++) {
            if(cnt[i]>=k) kor|= (1<<i);
        }
        return kor;
    }

}
