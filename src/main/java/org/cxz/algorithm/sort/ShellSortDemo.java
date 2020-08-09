package org.cxz.algorithm.sort;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Arrays;
import java.util.TooManyListenersException;

public class ShellSortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        //ShellSort(array);
        SSort(array);
        System.out.println("end "+ Arrays.toString(array));
    }

    public static void ShellSort(int[] a){
        int gap=0;
        int outer ,inner;
        int temp;
        int length = a.length;
        gap =a.length/2;

        while (gap>0){
            System.out.println("gap ==> "+gap+" "+Arrays.toString(a));
            for (  outer  = 0; outer <= length-1-gap; outer++) {
                temp = a[outer+gap];
                System.out.println(" outer ==>   " + outer+" temp ==>   " + temp);
                inner = outer+gap;
                while (inner-gap>=0&&a[inner-gap]>temp){
                    System.out.println(" inner ==>   " + inner+" temp ==>   " + temp);
                    System.out.println(" swaped ==>   " + a[inner-gap] + " <---> " + a[inner]);
                    a[inner]=a[inner-gap];
                    inner= inner-gap;
                    System.out.println("while inner ==>"+inner+" "+Arrays.toString(a));
                }
                a[inner]=temp;
                System.out.println("tmp into target ==>"+inner+" "+Arrays.toString(a));
            }
            gap= gap/2;

        }

    }

    public  static  void SSort(int[] a){
        int outer ,inner;
        int temp;
        int length = a.length;
        int h=1;
        while (h<=length/3){
            h =3*h+1;
        }
        while (h>0){
            System.out.println("gap ==> "+h+" "+Arrays.toString(a));
            for (outer  = h; outer <length-1 ; outer++) {
                temp = a[outer];
                System.out.println(" outer ==>   " + outer+" temp ==>   " + temp);
                inner =outer;
                while (inner>h-1&&a[inner-h]>temp){
                    System.out.println(" inner ==>   " + inner+" temp ==>   " + temp);
                    System.out.println(" swaped ==>   " + a[inner-h] + " <---> " + a[inner]);
                    a[inner]=a[inner-h];
                    inner=inner-h;
                    System.out.println("while inner ==>"+inner+" "+Arrays.toString(a));
                }
                a[inner]= temp;
                System.out.println("tmp into target ==>"+inner+" "+Arrays.toString(a));
            }
            h=(h-1)/3;
        }
    }
}
