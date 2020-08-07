package org.cxz.algorithm.sort;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2020/8/6 20:38
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr =new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};

        QuickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int[] a,int start ,int end){

        int i =start,j= end;
        int pivot = a[i];
        while (i<j){
            while (i<j&&a[j]>pivot){
                j--;
            }
            while (i<j&&a[i]<pivot){
                i++;
            }
            if (a[j]==a[i]&&i<j){
                i++;
            }else{
                int tmp = a[j];
                a[j]=a[i];
                a[i]=tmp;
            }
            System.out.println("i= "+i+"j="+j+" "+Arrays.toString(a));

            if (start<i-1) {
                QuickSort(a,start,i-1);
            }

            if (j+1<end) {
                QuickSort(a,j+1,end);
            }
        }

    }


}
