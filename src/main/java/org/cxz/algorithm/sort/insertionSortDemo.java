package org.cxz.algorithm.sort;

import java.util.Arrays;

public class insertionSortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{20, 40, 60, 80, 30, 70, 90, 10, 50, 0};
        InsertionSort(array);
        System.out.println("end "+ Arrays.toString(array));
    }

    public static void InsertionSort(int[] arr){
        int length = arr.length;
        for (int i =0 ; i <length-1; i++) {

            System.out.println("i "+i+" "+Arrays.toString(arr));
            for (int j =i+1; j>0&&arr[j]<arr[j-1] ; j--) {
                int tmp =0;
                if (arr[j-1]>arr[j]){
                    tmp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1] =tmp;
                }
            }
        }
    }
}
