package org.cxz.contest.test352week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/2 10:31
 */
public class test0702a {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length,ans = 0;
        for (int l = 0; l < n;l++) {
            if(nums[l]%2!=0) continue;
            if(nums[l]> threshold) continue;
            int r = l,len = 1;
            for ( ; r <n ; r++) {
                if(nums[r]> threshold) break;
                System.out.println("l "+l+ " r = " + r);
                len++;
            }
            for (int k = l; k <r; k++) {
                if(k+1==r||(nums[k] % 2 == nums[k+1] % 2)){
                    System.out.println("l "+l+ " r = " + r+" k break "+k);
                    break;
                }
                len++;
            }
            len = Math.max(1,len);
            ans = Math.max(ans,len);
        }
        return ans;
    }
}
