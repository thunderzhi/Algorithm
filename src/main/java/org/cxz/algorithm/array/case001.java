package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/11 22:44
 */
public class case001 {
    public static void main(String[] args) {

        int[] nums = {7,2,15,11,1};


    }

    public int[] classictwoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[1];
    }



    public int[] twoSum(int[] nums, int target) {
        Integer[] ind = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ind[i] = i;
        }
        Arrays.sort(ind, 0, ind.length , new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o1]-nums[o2];
            }
        });
        int[] ans = new int[2];
        for (int i = 0; i < ind.length; i++) {
            int a = ind[i];
            int j = find(nums,ind,i+1,target-nums[ind[i]]);
            if(j==-1){
                continue;
            }
            ans[0] = ind[i];
            ans[1] = ind[j];
            if(ans[0]>ans[1]){
                int t = ans[1];
                ans[1] =ans[0];
                ans[0] =t;
            }

            return ans;

        }
        ans[0]=-1;
        ans[1]=-1;
        return ans;
    }

    public int find(int[] arr,Integer[] ind,int l ,int target){
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[ind[mid]]==target){
                return mid;
            }
            if(arr[ind[mid]]>target){
                r  = mid-1;
            }
            else{
                l= mid+1;
            }
        }

        return -1;
    }
}
