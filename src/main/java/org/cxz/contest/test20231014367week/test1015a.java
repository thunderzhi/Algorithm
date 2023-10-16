package org.cxz.contest.test20231014367week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/14 23:58
 */
public class test1015a {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[]{-1,-1};
        int n = nums.length;
        for (int i = 0; i < n ; i++) {
            for (int j = i; j <n ; j++) {
                if(Math.abs(nums[i]-nums[j])>=valueDifference
                        &&Math.abs(i-j)>=indexDifference){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
