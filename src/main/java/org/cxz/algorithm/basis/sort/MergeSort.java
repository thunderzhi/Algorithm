package org.cxz.algorithm.basis.sort;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/20 15:49
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        System.out.println("arr length is " + arr.length);
        new MergeSort().merge_sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public void merge_sort(int[] arr,int l ,int r){
        if(l>=r){
            return;
        }
        int mid =l+(r-l)/2;
        merge_sort(arr,l,mid);
        merge_sort(arr,mid+1,r);
        int[] tmp = new int[r-l+1];
        int k = 0;
        int p = l;
        int q = mid+1;
        while(p<=mid||q<=r){
            if(q>r||(p<=mid&&arr[p]<=arr[q])){
                tmp[k++]= arr[p++];
            }
            else{
                tmp[k++] = arr[q++];
            }
        }
        k =0;
        for (int i = l; i <=r ; i++) {
            arr[i]= tmp[i-l];
        }
    }
}
