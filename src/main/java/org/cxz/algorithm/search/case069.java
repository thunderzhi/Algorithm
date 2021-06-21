package org.cxz.algorithm.search;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/21 11:47
 */
public class case069 {
    public static void main(String[] args) {


    }


    public int mySqrt(int x) {
        int l =0;
        int r =x ;
        int mid = 0;
        while(l<r){
            mid = (r - l) / 2 + l + 1;
            if(mid<=x/mid){
                l = mid;
            }
            else{
                r = mid-1;
            }
        }
        return l;

    }












}
