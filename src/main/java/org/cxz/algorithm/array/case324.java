package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/9 21:14
 */
public class case324 {
    public int length = 0;
    // ver 1
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] t = new int[n];
        int j = n - 1;
        for(int i = 1; i < n; i+=2 , j--){
            t[i] = nums[j];
        }
        for(int i = 0; i < n; i+=2 , j--){
            t[i] = nums[j];
        }
        for(int i = 0;i < n;i++){
            nums[i] = t[i];
        }
    }
    // ver2 O(N)
    public void wiggleSort2(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        int mid = (n%2==0)? (n-1)/2:n/2;//7/2 mid =3,8-1/2 mid =3
        getKth(nums,mid,0,n-1);

        triplePartion(nums,mid);
        int j = n - 1;
        for(int i = 1; i < n; i+=2 , j--){
            t[i] = nums[j];
        }
        for(int i = 0; i < n; i+=2 , j--){
            t[i] = nums[j];
        }
        for(int i = 0;i < n;i++){
            nums[i] = t[i];
        }

    }
    void triplePartion(int[] nums,int mid){
        // pre
        int p =0,q = mid;
        while(p<q){
            while(p<q&&nums[q]==nums[mid]) q--;
            while(p<q&&nums[p]<nums[mid]){
                p++;
            }
            if(p<q){
                swap(nums,p,q);
                p++;
                q--;
            }
        }
        //post
        p = mid+1;
        q = nums.length-1;
        while(p<q){
            while(p<q&&nums[p]==nums[mid]){
                p++;
            }
            while(p<q&&nums[q]>nums[mid]){
                q--;
            }
            if(p<q){
                swap(nums,p,q);
                p++;
                q--;
            }
        }
    }
    void getKth(int[] nums ,int K,int left,int right){
        if(left>=right) return;
        int x = left,y = right;
        int base = nums[x];
        while(x<y){
            while(x<y&&nums[y]>=base){
                y--;
            }
            if(x<y){
                nums[x++] =nums[y];
            }
            while(x<y&&nums[x]<=base){
                x++;
            }
            if(x<y){
                nums[y--] =nums[x];
            }
        }
        nums[x] = base;
        if(x-left+1>K){
            getKth(nums,K,left,x);
        }
        else{
            getKth(nums,K-(x-left+1),x+1,right);
        }
    }
    void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return;
    }

    int vitual(int i ){
        return (1+2*i)%(length|1);
    }

}
