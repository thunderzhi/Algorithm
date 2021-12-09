package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/8 22:39
 */
public class case014 {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix(String[] strs) {
        String ret = strs[0];
        for (int i =1; i < strs.length; i++) {
            ret = compare(ret,strs[i]);
        }
        return ret;
    }
    public String compare(String a,String b){
        String ret="";
        for (int i = 0; i < a.length(); i++) {
            if (i==b.length()||a.charAt(i)!=b.charAt(i)){
                return ret;
            }
            ret +=a.charAt(i);
        }
        return ret;
    }

}
