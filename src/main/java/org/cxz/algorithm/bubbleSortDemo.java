package org.cxz.algorithm;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class bubbleSortDemo {
    public static void main(String[] args) {
      int[] array = new int[]{20, 40, 60, 80, 30, 70, 90, 10, 50, 0};

        //BubbleSort(array);
        BubbleSort2(array);
        System.out.println("end "+Arrays.toString(array));
    }

    public static void BubbleSort(int[] arr){
        boolean flag= false;
        for (int i = (arr.length-1); i >0 ; i--) {

            System.out.println("i "+i+" "+Arrays.toString(arr));
            for (int j = 0; j <i ; j++) {
                if (arr[j]>arr[j+1]){
                    //swap
                    int tmp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=tmp;
                }
            }
        }
    }
    public static void BubbleSort2(int[] arr){
        for(int i =0 ; i<arr.length-1 ; i++) {
            System.out.println("i "+i+" "+Arrays.toString(arr));
            for(int j=0 ; j<arr.length-1-i ; j++) {

                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];

                    arr[j]=arr[j+1];

                    arr[j+1]=temp;
                }
            }
        }
    }
}