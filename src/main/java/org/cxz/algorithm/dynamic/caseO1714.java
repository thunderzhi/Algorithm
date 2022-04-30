package org.cxz.algorithm.dynamic;

import java.util.Arrays;
import java.util.Random;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/5/21 16:51
 */
public class caseO1714 {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,5,7,2,4,6,8};
        int[] ints = new caseO1714().smallestK(a, 5);

        System.out.println("ints = " + Arrays.toString(ints));

    }
    public int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];

        quicksort(arr,0,arr.length-1,k);
        if(k>0){
            for (int i = 0; i < k; i++) {
                ans[i] = arr[i];
            }
        }
        return ans;
    }

    private void quicksort(int[] arr, int left, int right, int k) {
        int l = left;
        int r = right;
        if(l>=r){
            return;
        }
        int mid = getmid(arr[l],arr[r],arr[(l+r)>>1]);

        do {
            while(arr[l]<mid){
                l++;
            }
            while(arr[r]>mid){
                r--;
            }
            if (l<=r){
                int p = arr[r];
                arr[r] = arr[l];
                arr[l] = p;
                l++;
                r--;
            }
        }while (l<=r);
        if (r-left== k-1){
            return;
        }
        if (r-left>=k){
            quicksort(arr,left,r,k);
        }else {
            quicksort(arr,l,right,k-l+left);
        }

    }

    public int getmid(int a,int b,int c){
        int max = Math.max(a, Math.max(b,c));
        int min = Math.min(a, Math.min(b,c));
        if(a!=max&&a!=min){return a;}
        if(b!=max&&b!=min){return b;}
        return c;
    }

    //ver 2 Recommendation PASS
    public int[] smallestK2(int[] arr, int k) {
        if(k==0) return new int[0];
        qs(arr,0,arr.length-1,k);
        return Arrays.copyOfRange(arr,0,k);
    }

    public void qs(int[] num ,int l,int r ,int k){
        if(l>=r) return;
        int x = l, y = r,i = new Random().nextInt(y-x+1)+x;
        if(i!= x) swap(num,i,x);
        int base = num[x];
        while(x<y){
            while(x<y&&num[y]>=base)y--;
            if(x<y) num[x++] = num[y];
            while(x<y&&num[x]<=base)x++;
            if(x<y) num[y--] = num[x];
        }
        num[x] = base;
        if(x-l+1==k) return;
        if(x-l+1>k){
            qs(num,l,x-1,k);
        }
        else{
            qs(num,x+1,r,k-(x-l+1));
        }
        return;
    }

    public void swap(int[] num ,int i,int j){
        int t = num[i];
        num[i] = num[j];
        num[j] =t;
        return;
    }
}
