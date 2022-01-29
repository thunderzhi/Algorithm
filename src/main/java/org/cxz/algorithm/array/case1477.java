package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/28 15:53
 */
public class case1477 {

    public int minSumOfLengths(int[] arr, int target) {
        int l =0;
        List<int[]> ranges = new ArrayList();
        int sum =0;
        for(int r =0;r<arr.length;r++){
            sum+=arr[r];
            while(sum>target&&l<=r){
                sum -= arr[l];
                l++;
            }
            if(sum==target){
                ranges.add(new int[]{l,r});
            }
        }
        int ans = -1 ;
        int premin =arr.length+1;
        int preind = -1;

        for(int[] x:ranges){
            // System.out.println("x1: "+x[0]+" x2: "+x[1]);
            while(ranges.get(preind+1)[1]<x[0]){
                preind +=1;
                premin = Math.min(premin,ranges.get(preind)[1]-ranges.get(preind)[0]+1);
            }
            if(preind ==-1){continue;}
            if(ans==-1||ans>premin +x[1]-x[0]+1){
                ans =premin +x[1]-x[0]+1;
            }
        }
        return ans;
    }
}
