package org.cxz.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/19 22:57
 */
public class case912 {

    public static void main(String[] args) {
        int[] a =new int[]{-2,3,-5};
        new case912().sortArray(a);
        System.out.println("ArrayList = " + Arrays.toString(a));

    }

    public int[] sortArray(int[] nums) {
         if(nums.length==1){
             return nums;
         }
        _quicksort(nums);
        return nums;
    }

    /*
    pass
     */
    public void q_s_v1(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int x = l;
        int y=r;
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
        q_s_v1(arr,l,x-1);
        q_s_v1(arr,x+1,r);
        return;
    }



    public void _quicksort(int[] arr){
        int l = 0;
        int r = arr.length-1;
        quicksort(arr,l,r);
    }

    public void quicksort(int[] arr,int l,int r){
        if(l>=r){
            return;
        }
        int pivot = chosepivot(arr,l,r);
        int x = l;
        int y = r;

        while(x<y){
            if(arr[x]<=pivot){
                x++;
                continue;
            }
            if(arr[y]>=pivot){
                y--;
                continue;
            }
            if (x<y) {
                int p = 0;
                p = arr[x];
                arr[x] =arr[y];
                arr[y] =p;
                x++;
                y--;
            }
        }
        arr[x] =pivot;
        quicksort(arr,l,x-1);
        quicksort(arr,x+1,r);
        return;
    }

    public int chosepivot(int[] arr,int l,int r ){
        if(r-l==1){
            return arr[l];
        }
        int mid = (l+r)>>1;
        int a = arr[l];
        int b = arr[mid];
        int c = arr[r];
        //a<b<c
        int p =0;
        if(a>c){
            p =c;
            c = a;
            a =p;
        }
        if(b>c){
            p =c;
            c = b;
            b =p;
        }
        if(a>b){
            p =b;
            b = a;
            a =p;
        }
        return b;
    }
}
