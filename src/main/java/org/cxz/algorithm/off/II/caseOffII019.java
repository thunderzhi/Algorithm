package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/24 17:31
 */
public class caseOffII019 {

    //ver 1
    public boolean validPalindrome(String s) {
        int n = s.length();
        int l =0, r=n-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) break;
            l++;r--;
        }
        if(l>=r) return true;
        return ispalindrome(s,l+1,r)||ispalindrome(s,l,r-1);
    }
    public boolean ispalindrome(String s,int l,int r){
        if(l>r) return false;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}
