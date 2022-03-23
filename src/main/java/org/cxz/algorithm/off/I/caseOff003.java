package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/16 11:44
 */
public class caseOff003 {

    // ver 1 O1
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(i==nums[i]) continue;
            int res = recovery(i,nums);
            if(res!=-1) return res;
        }
        return -1;
    }

    public int recovery(int x,int[] nums){
        while(x != nums[x]){
            int ind = nums[x];
            if(ind == nums[ind]) return ind;
            swap(nums,ind,x);
        }
        return -1;
    }

    public void swap(int[] arr,int i ,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return;
    }
}
