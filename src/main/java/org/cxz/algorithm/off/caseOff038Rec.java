package org.cxz.algorithm.off;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: backtrack not good ver 1
 * @date 2022/2/16 15:02
 */
public class caseOff038Rec {
    public String[] permutation(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        List<String> list = new ArrayList();
        do{
            list.add(new String(arr));
        }while(nextpermutaion(arr));
        String[] ans = list.toArray(new String[list.size()]);
        return ans;
    }

    public boolean nextpermutaion(char[] arr){
        int i = arr.length-2;
        while(i>=0&&arr[i]>=arr[i+1]){
            i--;
        }
        if(i<0) return false;
        if(i>=0){
            int j = arr.length-1;
            while(j>=0&&arr[j]<=arr[i]){
                j--;
            }
            swap(arr,i,j);
        }
        reverse(arr,i+1,arr.length-1);
        return true;
    }


    public void swap(char[] arr,int l,int r){
        char c= arr[l];
        arr[l]= arr[r];
        arr[r] = c;
        return;
    }

    public void reverse(char[] arr,int l,int r){
        while(l<r){
            swap(arr,l,r);
            l++;
            r--;
        }
        return;
    }
}
