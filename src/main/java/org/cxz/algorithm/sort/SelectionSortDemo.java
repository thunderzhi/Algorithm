package org.cxz.algorithm.sort;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2020/8/6 19:43
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] arr =new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void SelectionSort(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            int tmp = 0;
            int smallindex = i;
            System.out.println("i "+i+" "+Arrays.toString(a));
            for (int j = i+1; j < a.length-1 ; j++) {
                if (a[smallindex]>a[j]){

                    smallindex = j;
                }
            }
            System.out.println(i+" times smallest is "+ smallindex);
            tmp = a[smallindex];
            a[smallindex]=a[i];
            a[i]=tmp;
        }
    }
}
