package org.cxz.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2020/8/6 20:38
 */
public class QuickSort2Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        System.out.println("arr length is " + arr.length);
        partition(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }



    public static void partition(int[] arr,int l,int r){
        if(l>=r){
            return  ;
        }
        int x = l;
        int y=r;
        int i = new Random().nextInt(r - l + 1) + l; // 随机选一个作为我们的主元

        if (i!=l){
            swap(arr,i,l);
        }
        int base = arr[l];
        while(x<y){
            while (x<y && arr[y]>=base){
                y--;
            }
            if(x<y){
                arr[x++] = arr[y];
            }
            while (x<y && arr[x]<=base){
                x++;
            }
            if(x<y){
                arr[y--] = arr[x];
            }
        }
        arr[x] =base;
        partition(arr,l,x-1);
        partition(arr,x+1,r);
        return  ;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
