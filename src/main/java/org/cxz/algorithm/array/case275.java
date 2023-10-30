package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/22 18:52
 */
public class case275 {
    public int hIndex(int[] citations) {
        int n = citations.length; 
        int l = 0, r = n-1,mid = 0;
        if(citations[0]>=n) return n;
        while(l<r){
            mid = (l+r+1)/2;
            if( citations[n-mid]>=mid) l = mid;
            else r = mid-1;
        }
        return l;
    }
}
