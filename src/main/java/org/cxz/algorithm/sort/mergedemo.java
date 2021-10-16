package org.cxz.algorithm.sort;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/16 15:30
 */
public class mergedemo {
    public static void main(String[] args) {

    }

    public void merge_sort(int[] arr,int l ,int r){
        if(l>=r){
            return;
        }
        int mid =l+(r-l)/2;
        merge_sort(arr,l,mid);
        merge_sort(arr,mid+1,r);
        int[] tmp = new int[arr.length];
        int k = 0;
        int p = l;
        int q = mid+1;
        while(p<=mid||q<=r){
            if(q>r||(p<=mid&&arr[p]<=arr[q])){
                tmp[k++]= arr[p++];
            }
            else{
                tmp[k++] = arr[q++];
            }
        }
        k =0;
        for (int i = l; i <=r ; i++) {
            arr[i]= tmp[i-l];
        }
    }
}
