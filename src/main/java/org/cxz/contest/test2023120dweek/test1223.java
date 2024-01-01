package org.cxz.contest.test2023120dweek;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/12/23 22:29
 */
public class test1223 {
    int n ;
    public int incremovableSubarrayCount(int[] nums) {
        n = nums.length;
        if(n==1)  return 1;
        int ans = 0;
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i+len-1 < n ; i++) {
                if(check(nums,i,len)) ans++;
            }
        }
        return ans;
    }
    public boolean check(int[] arr,int idx,int len){
        // idx    end     end - idx +1 = len  end = len+idx -1
        int pre = -1;
        for(int i = 0;i<idx;i++){
            if(pre==-1){
                pre = arr[i];
                continue;
            }
            if(pre<=arr[i])return false;
            pre = arr[i];
        }
        for (int i = len +idx ; i < n ; i++) {
            if(pre==-1){
                pre = arr[i];
                continue;
            }
            if(pre<=arr[i]) return false;
            pre = arr[i];
        }
        return true;
    }

    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        long[] sum = new long[n+1];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i]+ nums[i];
        }
        long ans = -1;
        for (int i = n-1; i >=2 ; i--) {
            if(sum[i]>nums[i]){
                ans = sum[i]+ nums[i];
                break;
            }
        }
        return ans;
//        int l =
        //
        // m arr[0~m-2]> arr[m-1]   sum[m-1]
        // m-1 arr[0~m-2-1]> arr[m-1-1]

    }

    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int p =1;
        while(p<n&& nums[p-1]>=nums[p]) p++;


        while(p<n&& nums[p-1]<nums[p]) p++;
        long ans = 0;
        if(p==n){
            // whole arr
            ans = (long)n*(long)(n+1)/2;
            return ans;
        }
        int q = n-2;
        while(q>=0&&nums[q]<nums[q+1]) q--;
        // 0~p-1     q+1~n-1
        int i = 0,j = q+1,k=q+1;

        while (i<p) {
            while(k<n&& nums[k]<=nums[i]) k++;
            if(k==n){
                ans += p -i;
                break;
            }
            //k<n
            ans += n-k+1;  // 以i为结尾的前半段 ,以k开始的后半段 ,del subarr end with k-1
            i++;
        }
        k=p;
        while(j>q){
            while(k>=0&&nums[k]>=nums[j]) k--;
            if(k==0){
                ans += j-(q+1)+1;
                break;
            }
            ans += k+2;
            j--;
        }
        return ans;




    }
}
