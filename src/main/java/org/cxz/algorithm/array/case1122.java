package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/22 17:05
 */
public class case1122 {

    public static void main(String[] args) {

    }
    //ver 1 pass imitative hash
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1005];
        for(int x : arr1){
            map[x]+=1;
        }
        int k =0;
        for(int i = 0;i<arr2.length;i++){
            int t = arr2[i];
            while(map[t]-->0) arr1[k++]= t;
        }
        for(int i= 0;i<map.length;i++){
            if(map[i]==0) continue;
            while(map[i]-->0) arr1[k++] =i;
        }
        return arr1;
    }
}
