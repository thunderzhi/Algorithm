package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/12 9:39
 */
public class case2562 {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int x = nums[i];
            int y = nums[j];
            while (y != 0) {
                x *= 10;
                y /= 10;
            }
            ans += x + nums[j];
            i++;
            j--;
        }
        if (i == j) {
            ans += nums[i];
        }
        return ans;
    }
}
