package org.cxz.algorithm.classic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/11 15:04
 */
public class binarySearch01 {
    public static void main(String[] args) {


    }

    //find first index of element bigger than x.
    public int binarySearch_01(int[] arr,int x){
        int head = 0;
        int tail = arr.length-1;
        while(tail-head>3){
            int mid = head+(tail-head)/2;
            if(arr[mid]>=x){
                tail = mid;
            }
            else{
                head = mid+1;
            }
        }
        for (int i = head; i <= tail; i++) {
            if(arr[i]>=x){
                return i;
            }
        }
        return  -1;
    }
}
