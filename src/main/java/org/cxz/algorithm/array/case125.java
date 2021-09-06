package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/30 10:07
 */
public class case125 {

    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int n = chars.length;
        int p,q;
        p = 0;
        q = n-1;
        while (p<q){
            if (!isUseChar(chars[p])){
                p++;//
                continue;
            }
            if (!isUseChar(chars[q])){
                q--;//
                continue;
            }
            if (isUseChar(chars[p])&&isUseChar(chars[q])){
                if (chars[p]==chars[q]){
                    p++;
                    q--;
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUseChar(char c){
        return (Character.isDigit(c)||Character.isLetter(c))?true:false;
    }

}
