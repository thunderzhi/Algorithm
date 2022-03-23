package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/16 11:46
 */
public class caseOff053II {

    //ver 1 On
    public int missingNumber(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            if(i == nums[i]) continue;
            return i;
        }
        return nums.length ;
    }
    // ver 2 OlogN
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int i = find(nums);
        int ans = i;
        if(i==n-1 ){
            ans = nums[i]==i? n:n-1;
            return ans;
        }
        return ans;
    }

    public int find(int[] nums){
        int n = nums.length;
        int l = 0, r = n-1;
        int mid = 0;
        while(l<r){
            mid = l+(r-l)/2;
            if(nums[mid]>mid){
                r = mid;
            }
            else{
                l =mid +1;
            }
        }
        return l;
    }

}
