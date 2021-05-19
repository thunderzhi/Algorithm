package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/20 0:17
 */
public class caseO021 {

    public static void main(String[] args) {


    }



    public int[] exchange(int[] nums) {
        process(nums,0,nums.length-1);
        return nums;
    }

    public void process(int[] arr, int l,int r){
        if(l>=r){
            return;
        }
        while (l<r){
            while(l<r&&arr[l]%2==1){
                l++;
            }
            while(l<r&&arr[r]%2==0){
                r--;
            }
            if (l<r){
                int p =0;
                p = arr[l];
                arr[l] = arr[r];
                arr[r] = p;
                l++;
                r--;
            }
        }

    }

}
