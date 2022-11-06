package org.cxz.contest.test1030;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/10/30 10:31
 */
public class test1030a {

    public int averageValue(int[] nums) {
        int n = nums.length;
        int sum=0,cnt =0;
        for (int i = 0; i < n; i++) {
            if(nums[i]%3==0&&nums[i]%2==0){
                sum+=nums[i];
                cnt++;
            }
        }
        if(cnt==0) return 0;
        return sum/cnt;
    }
}
