package org.cxz.algorithm;




public class binarySearchDemo {
    public static void main(String[] args) {
        int[] arr  =new int[]{3,4,6,20,40,45,51,62,70,99,111};

        int index =binarySearch(arr,99);
        System.out.println("index = "+index);
    }

    public static int binarySearch(int[] arr,int key){
        int length = arr.length;
        int begin =0;
        int end = length-1;
        int index =0;
        int i=0;
        int stab =0;
        while (begin<end){
            stab =(begin+end)/2;
            System.out.println("i = "+i+" stab ="+stab+" []="+arr[stab]);
            i++;
            if (arr[stab]==key){
                index = stab;
                return index;
            }

            if (arr[stab]<key){
                begin = stab + 1;
            }
            else {
                end=stab -1;
            }


        }

        return index;
    }
}

