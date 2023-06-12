package org.cxz.contest.test20230521346week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/21 10:17
 */
public class test0521b {
    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0,r = arr.length-1;
        while(l<r){
            char lc = arr[l];
            char rc = arr[r];
            if(lc!=rc){
                if(lc<rc) arr[r] = lc;
                else arr[l]=rc;
            }
            l++;r--;
        }
        return new String(arr);

    }
}
