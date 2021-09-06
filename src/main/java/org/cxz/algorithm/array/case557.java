package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/5 17:13
 */
public class case557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String s1 = new case557().reverseWords(s);
        System.out.println("s1 = " + s1);;

    }

    public String reverseWords(String s) {
        if (s.length()<=1){
            return s;
        }
        char[] chars = s.toCharArray();
        int n = s.length()-1;
        for (int i = 0; i <= n ; i++) {
            for (int j = i; j <= n; j++) {
                if (chars[j]!=' '&&j==n){
                    reverse(chars,i,j);
                    return String.valueOf(chars);
                }
                if(chars[j]!=' '&&j<n){
                    continue;
                }
                reverse(chars,i,j-1);
                i=j;
                break;
            }
        }
        return String.valueOf(chars);
    }

    public void reverse(char[] chars ,int l,int r ){
         while(l<=r){
            char c = chars[l];
            chars[l]= chars[r];
            chars[r] = c;
            l++;
            r--;
        }
        return;
    }
}
