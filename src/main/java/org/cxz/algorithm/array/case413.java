package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/23 21:10
 */
public class case413 {

    //ver 1  formula
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        int[] arr = new int[n-1];
        for(int i =0;i<n-1;i++){
            arr[i]= nums[i+1]-nums[i];
        }
        int left=0,right=0,sum =0;
        while(right<arr.length){
            while(right<arr.length-1&&arr[right]==arr[right+1]){
                right++;
                //System.out.println("right: "+right);
            }
            sum+= getSeq(left,right);
            right++;
            left= right;
        }
        return sum;
    }

    public int getSeq(int left, int right){
        if(right - left +1<2) return 0;
        int l = right - left+1+1;
        return (l-1)*(l-2)/2;
    }

    //ver 2 dp
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        int cnt = 0;
        int[] dp = new int[n+1];
        for(int i = 2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i] =dp[i-1]+1;
                cnt += dp[i];
            }
        }
        return cnt;
    }

    //ver 3
    public int numberOfArithmeticSlices3(int[] nums) {
        int n = nums.length;
        if(n<3) return 0;
        int cnt = 0;
        int dp =0 ;
        for(int i = 2;i<n;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp++;
                cnt += dp;
            }
            else{
                dp =0;
            }
        }
        return cnt;
    }
}
