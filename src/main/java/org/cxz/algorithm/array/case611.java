package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/20 16:34
 */
public class case611 {
    public static void main(String[] args) {
        //int[] arr = new int[]{2,2,3,4};//66,99,36,44,26,99,32,64,19,69
        int[] arr = new int[]{66,99,36,44,26,99,32,64,19,69};//66,99,36,44,26,99,32,64,19,69
        //[16,70,16,36,17,39,44,72,25,88,18,22,20,84,18,66,71,74,87,59,48,91,52,15,92,29,85,21,10,34,86,68,10,27,3,42,49,48,18,15,6,39,61,28,19,52,60,8,37,32,71,82,54,38,47,33,10,64,52,71,39,63,64,79,86,47,16,72,55,17,35,88,74,93,10,59,3,64,95,91,61,28,63,23,49,6,24,47,41,88,96,23,90,53,84,3,35,23,3,17]
        int i = new case611().triangleNumber(arr);
        System.out.println("i = " + i);

    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        System.out.println("nums.length = " + nums.length);
        // a+b>c
        // a-b<c
        int n = nums.length;
        int ans =0;
        for (int i = 0; i < n-2 ; i++) {
            for (int j =i+1; j < n - 1; j++) {
                int x = nums[i]+nums[j];
                int left = j+1;
                int right = n-1;
                int first = find01(nums,left,right,x);
                ans += first-1-j;
            }
        }
        return ans;
    }

    // find first bigger than tar
    public int find01(int[] arr ,int left,int right,int tar){
        int l = left;
        int r = right;
        int mid = 0;
        while(r-l>3){
            // l+(r-l)>>1 cannot avoid locate the same mid    bug casue by +  calc before >>
            mid = l+(r-l)/2;
            //mid = (r+l+1)>>1;
            if(arr[mid]>=tar){
                r = mid;
            }
            else{
                l = mid+1;
            }

        }
        for (int i = l; i <=r; i++) {
            if(arr[i]>=tar){
                return i;
            }
        }
        return arr.length;
    }

    //another method double point
    public int doublePoint(int[] nums){
        int n = nums.length;
        int ans =0;
        for (int i =n-1; i >1 ; i--) {
            int l = 0;
            int r =i-1;
            while (l<r){
                if(nums[l]+nums[r]>nums[i]){
                    ans +=r-l;
                    r-=1;
                }
                else{
                    l+=1;
                }
            }
        }
        return ans;
    }
}
