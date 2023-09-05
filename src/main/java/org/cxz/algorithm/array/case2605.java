package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/5 23:36
 */
public class case2605 {

    public int minNumber(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        int min1 = nums1[0],min2= nums2[0];
        int[] cnt = new int[10];
        for(int i=0;i<n1;i++){
            cnt[nums1[i]]++;
            min1 = Math.min(min1,nums1[i]);
        }
        for(int i=0;i<n2;i++){
            cnt[nums2[i]]++;
            min2 = Math.min(min2,nums2[i]);
        }
        for(int i=1;i<=9;i++){
            if(cnt[i]==2) return i;
        }
        return min1<min2? min1*10+min2:min2*10+min1;
    }

    public int minNumber2(int[] nums1, int[] nums2) {
        int mask1 = 0, mask2 = 0;
        for (int x : nums1) mask1 |= 1 << x;
        for (int x : nums2) mask2 |= 1 << x;
        int m = mask1 & mask2;
        if (m > 0) return Integer.numberOfTrailingZeros(m); // 有交集
        int x = Integer.numberOfTrailingZeros(mask1);
        int y = Integer.numberOfTrailingZeros(mask2);
        return Math.min(x * 10 + y, y * 10 + x);
    }

}
