package org.cxz.algorithm.dynamic;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/6 21:43
 */
public class case169 {
    public static void main(String[] args) {




    }



    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length>>1;
        for (int i = 0; i <= nums.length-1; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else{
                Integer t = map.get(nums[i]);
                map.put(nums[i],t+1);
            }
        }
        for ( Integer item :map.keySet()){
            if (map.get(item)>n){
                return item;
            }
        }
        return 0;
    }
    //Boyer-Moore
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for(int i= 0;i<nums.length;i++){
            if(count==0){
                candidate = nums[i];
                count++;
                continue;
            }
            count =candidate==nums[i]?count+1:count-1;
        }
        return candidate;
    }
}
