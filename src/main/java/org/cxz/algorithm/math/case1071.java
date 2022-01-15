package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/15 16:32
 */
public class case1071 {

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }

        int res = gcd(str1.length(),str2.length());
        String ans = str1.substring(0,res);
        return ans;

    }

    public int gcd(int a ,int b){
        if(b>0){
            return gcd(b,a%b);
        }
        return a;

    }

}
