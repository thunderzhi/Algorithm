package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/22 17:28
 */
public class case164 {
    public static void main(String[] args) {

    }
    //ver 1 pass radixsort
    public int maximumGap(int[] nums) {
        int m = nums.length;
        if(m<2) return 0;
        int n = 1<<16;
        int[] cnt = new int[n];
        int[] tmp = new int[m];
        for(int i =0;i<m;i++ ) cnt[l16(nums[i])]+=1;
        for(int i=1;i<n;i++) cnt[i]+=cnt[i-1];
        for(int i =m-1;i>=0;--i ) tmp[--cnt[l16(nums[i])]] = nums[i];
        Arrays.fill(cnt,0);
        for(int i =0;i<m;i++ ) cnt[h16(tmp[i])]+=1;
        for(int i=1;i<n;i++) cnt[i]+=cnt[i-1];
        for(int i =m-1;i>=0;--i ) nums[--cnt[h16(tmp[i])]] = tmp[i];
        int ans = 0;
        //System.out.println(Arrays.toString(nums));
        for(int i =1;i<m;i++){
            ans = Math.max(ans,nums[i]-nums[i-1]);
        }
        return ans;
    }
    public int h16(int a){
        return (a&0xffff0000)>>16;
    }
    public int l16(int a){
        return (a&0xffff);
    }
}
