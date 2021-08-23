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
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        System.out.println("arr length is " + arr.length);
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void QuickSort(int[] a, int start, int end) {

            int i = start, j = end;
            int pivot = 0;
            pivot = partition(a, start, end);
            System.out.println("**************** strat= " + start + " ********** end= " + end + " *****************************************");
            System.out.println("pivot index = " + pivot + " i= " + i + " j= " + j + " " + Arrays.toString(a));
            if (pivot-1>start ) {
                QuickSort(a, start, pivot - 1);
            }

            if (end>pivot+1) {
                QuickSort(a, pivot + 1, end);
            }
    }

    public static int partition(int[] a, int low, int high) {
        System.out.println("low = " + low + " high = " + high);
        int key = a[low];
        System.out.println("key value is  a[" + low + "]=  " + key);
        int pivotindex = low;
        //low = low+1;
        int index = 0;
        while (low < high) {
            while (low < high && a[high] > key) {
                high--;
            }
            while (low < high && a[low] <= key) {
                low++;
            }
            System.out.println(" high = " + high + " --->" + a[high] + " low= " + low + " ----->" + a[low]);
            if (low < high) {
                int tmp = a[low];
                a[low] = a[high];
                a[high] = tmp;
                System.out.println(" swaped ==>   " + a[high] + " <---> " + a[low]);
            }
            if (low == high && a[pivotindex] > a[low]) {

                a[pivotindex] = a[low];
                a[low] = key;
                System.out.println("key ------> a[l]=" + a[pivotindex]);
            }
            index = low;
            System.out.println("partition key = " + key + " low= " + low + " high= " + high + " " + Arrays.toString(a));
        }
        return index;
    }



}
