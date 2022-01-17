package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/17 14:55
 */
public class case941 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3) return false;
        int i =0, j = n-1;
        while(i<j&&arr[i]<arr[i+1]){
            i++;
        }
        while(i<j&&arr[j]<arr[j-1]){
            j--;
        }
        return i==j &&(i!=n-1) &&(j!=0);
    }
}
