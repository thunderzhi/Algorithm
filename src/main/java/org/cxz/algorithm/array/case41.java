package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/21 15:52
 */
public class case41 {
    public static void main(String[] args) {

    }
    public void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0;i<nums.length;i++){
            while(nums[i]!=i+1){
                if(nums[i]>n||nums[i]<=0){
                    break;
                }
                int ind = nums[i]-1;
                if(nums[i]==nums[ind]){
                    break;
                }
                swap(nums,i,ind);
            }
        }
        int ind =0;
        //cannot use for, cause the miss nums could bigger than length
        while(ind<nums.length&&nums[ind]==ind+1){
            ind++;
        }
        return ind+1;
    }



}
