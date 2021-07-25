package org.cxz.algorithm.search;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/25 10:00
 */
public class case475 {
    public static void main(String[] args) {

    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0; i < houses.length ; i++) {
            int x = houses[i];
            int j = binarysearch01(heaters,x);
            int left =Math.abs(x-heaters[j]);
            int right = j==0?left+1:x-heaters[j-1];
            ans = Math.max(ans,Math.min(left,right));
        }
        return ans;
    }

    // find index of the first element bigger than x
    // if exists return index, OR finally return the last index of element that smaller than x.
    public int binarysearch01(int[] arr ,int x){
        int head =0;
        int tail = arr.length-1;
        int mid =0;
        while (head<tail){
            mid = (head+tail)>>1;
            if (arr[mid]>=x){
                tail = mid;
            }
            else{
                head = mid+1;
            }
        }
        return head;
    }
}
