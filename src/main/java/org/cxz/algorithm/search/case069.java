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

    //ver bymy find first ele > =sqrt(x)
    public int mySqrt2(int x) {
        if(x<=1) return x;
        return find01(x);
    }

    public int find01(int x){
        int l =1,r = x/2+1, mid;
        while(l<r){
            mid = l+(r-l)/2;
            //System.out.println("l: "+ l+" r: "+ r+" mid:"+mid);
            //if((long)mid*mid == x) return mid;
            if((long)mid*mid >= x){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        if((long)l*l == x) return l;
        return l-1;
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
    //边界问题 要处理好 ，不同的==位置，最后取的结果亦不相同 思路很不错，但是这个时间复杂度不够好
    public int mysqrt_cap(int x){
        double head =0;
        double tail =x;
        double mid=0;
        for (int i = 0; i < 100; i++) {
            mid = head+(tail-head)/2.0;
            if(mid<=x/mid){
                head = mid;
            }
            else{
                tail =mid;
            }
        }

       return (int) Math.floor(head);

    }

}
