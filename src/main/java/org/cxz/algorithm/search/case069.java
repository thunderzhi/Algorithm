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

    // classic binary
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

    //newton iteration
    public int nt(int x){
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

    //01 solution
    public int binary_01(int x){
        if(x<=1){
            return x;
        }
        int l = 0;
        int r = x;

        while(r -l>3){
            int mid = l+((r-l)>>1);

            if(mid>=x/mid){
                r = mid;
            }
            else{
                l=mid+1;
            }
        }
        int res = l ;
        //System.out.println("l= "+l+ " r =" +r);
        for(int i = l;i<=r;i++){
            if(i==0){
                continue;
            }
            if(i<x/i){
                continue;
            }
            else if(i==x/i){
                res = i;
                return i;
            }
            else{
                res =i-1;
                return res;
            }
        }
        return res;
    }
}
