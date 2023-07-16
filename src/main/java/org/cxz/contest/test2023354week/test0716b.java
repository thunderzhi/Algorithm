package org.cxz.contest.test2023354week;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/16 10:27
 */
public class test0716b {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length,ans =0;
        Arrays.sort(nums);
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = 0; i < n; i++) {
            up[i] = nums[i]+k;
            down[i] = nums[i]-k;
        }
        System.out.println("nums = " +Arrays.toString(nums) );
        for (int i = 0; i < n;i++ ) {
            int u = up[i],d = down[i];
            int j = find(nums,nums[i],i+1,k);
            int len = j-i;


//            System.out.println("i = " + i+" nums[i] : "+nums[i]+ " u "+u+ " d "+d);
//            while(j<n){
//                int curup = up[j],curdown = down[j];
//                System.out.println("j = " + j+" nums[j] : "+nums[j]+ " cu "+curup+ " cd "+curdown);
//
//                if((u<curdown)||(d>curup)){
//                    // break
//                    break;
//                }
//                len = j-i+1;
//                u = Math.min(u,curup);
//                d = Math.max(d,curdown);
//                System.out.println("i = " + i+" nums[i] : "+nums[i]+ " u "+u+ " d "+d);
//
//                j++;
//            }
            System.out.println(" i "+i+" len = " + len);

            ans = Math.max(ans,len);
//            i = j;
        }
        return ans;

    }
    // find first a[j]-k>x+k, return j
    public int find(int[] nums,int x,int left,int k ){
        if(left==nums.length) return nums.length;
        int l = left,r = nums.length-1 ,mid =0 ;
        int tar = x+ 2*k;
        if(nums[l]>tar) return l;
        if(nums[r]<=tar) return nums.length;
        //a[j]>x+2k
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[mid]>tar) r = mid;
            else l = mid+1;
        }
        return l;
    }
    
}
