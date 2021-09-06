package org.cxz.algorithm.search;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/3 21:49
 */
public class case278 {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int l =1;
        int r =n;
        int mid =0;
        while(r-l>3){
            //mid= (l+r)>>1;
            mid = l + ((r -l)>>1);
            if(isBadVersion(mid)){
                r = mid;
            }
            else{
                l= mid+1;
            }
        }

        for(int i = l;i<=r;i++){
            if(!isBadVersion(i)){
                continue;
            }
            return i;
        }
        return l;
    }

    public boolean isBadVersion(int i){
        return true;
    }

}
