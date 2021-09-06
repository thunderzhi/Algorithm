package org.cxz.algorithm.array;

import java.rmi.ConnectIOException;
import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/5 10:36
 */
public class case167 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,24,50,79,88,150,345};
        int tar = 200;
        int[] ints = new case167().twoSum2(arr, tar);
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));

    }


    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length-1;
        int[] res = new int[2];
        //双指针顺序检索
        for (int i = 0; i <= n  ; i++) {
            for (int j = i+1; j <=n ; j++) {
                int tmp = numbers[i]+numbers[j];
                if (tmp>target){
                    break;
                }
                if(tmp<target){
                    continue;
                }
                if(tmp==target){
                    res[0]=i+1;
                    res[1]=j+1;
                    return res;
                }
            }
        }
        return res;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length-1;
        int[] res = new int[2];
        for (int i = 0; i <=n ; i++) {
            int t = target - numbers[i];
            int k = binaryS(numbers, i + 1, n, t);
            if (k==-1){
                continue;
            }
            res[0]=i+1;
            res[1]=k+1;
            return res;
        }
        return res;
    }

    public int binaryS(int[] nums,int l ,int r, int target){
        int mid = 0;
        while(r -l>3){
            mid = l+((r-l)>>2);
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                l= mid+1;
            }
            else{
                r = mid-1;
            }
        }
        for (int i = l;i<=r;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;

    }
}
