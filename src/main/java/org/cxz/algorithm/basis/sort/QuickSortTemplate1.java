package org.cxz.algorithm.basis.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/18 16:16
 */
public class QuickSortTemplate1 {

    public static void main(String[] args) {
        int[] n = new int[3];
        Arrays.copyOfRange(n,1,2);
    }

    // get mid num of 3 nums
    public int getmid(int a,int b,int c){
        int t =0;
        if(a>b){
            //swap a,b , a<=b
            t = a;
            a = b;
            b = t;
        }
        if(a>c){
            //swap a,c , a<=c now a is min or equal others
            t = a;
            a = c;
            c = t;
        }
        if(b>c){
            //swap b,c , b<=c
            t = b;
            b = c;
            c = t;
        }
        return b;
    }

    //ver 1
    // NOT Recommendation but idea is good  NOT FINISH
    // l is the first index of arr ,r is the last index of arr
    public void quicksort1(int[] arr,int l,int r){
        if(l>=r) return;
        int x = l ,y = r,mid = getmid(arr[x],arr[l+(r-l)/2],arr[y]);
        do{
            while(arr[x]<mid) x++;
            while(arr[y]>mid) y--;
            if(x<=y){
                swap(arr,x,y);
                x++;y--;
            }
        }while(x<=y);
        quicksort1(arr,x,r);
        quicksort1(arr,l,x-1);
        return;
    }

    // ver 2
    // Recommendation ,random is good
    public void quicksort2(int[] arr,int l,int r){
        if(l>=r) return;
        int x = l ,y = r,i = new Random().nextInt(y-x+1)+x;
        if(i!=x){
            swap(arr,i,x);
        }
        int base = arr[x];
        while(x<y){
            while(x<y&&arr[y]>=base) y--;
            if(x<y){
                arr[x++] = arr[y];
            }
            while(x<y&&arr[x]<=base) x++;
            if(x<y){
                arr[y--] = arr[x];
            }
        }
        arr[x] = base;
        quicksort2(arr,x+1,r);
        quicksort2(arr,l,x-1);
        return;
    }


    //swap two nums of array
    public void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        return;
    }
}
