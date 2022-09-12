package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/12 22:06
 */
public class case1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int x = 0; x < 1010; x++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (nums[r] >= x && x == n - r) return x;
        }
        return -1;
    }
}
