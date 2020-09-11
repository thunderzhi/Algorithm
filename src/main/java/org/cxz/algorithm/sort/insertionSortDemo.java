package org.cxz.algorithm.sort;

import java.util.Arrays;

public class insertionSortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        InsertionSort(array);
        System.out.println("end "+ Arrays.toString(array));
    }

    public static void InsertionSort(int[] arr){
        int length = arr.length;
        for (int i =0 ; i <length-1; i++) {
            int tmp =arr[i+1];
            System.out.println("i "+i+" "+Arrays.toString(arr));
            int j = i+1;

            while (j>0&&arr[j-1]>=tmp ) {
                System.out.println(" tmp ==>   " + tmp);
                System.out.println(" swaped ==>   " + arr[j-1] + " <---> " + arr[j]);
                arr[j]=arr[j-1];

                j--;
                System.out.println("while j ==>"+j+" "+Arrays.toString(arr));
            }

            arr[j]=tmp;
            System.out.println("tmp into target ==>"+j+" "+Arrays.toString(arr));
        }
    }
}
