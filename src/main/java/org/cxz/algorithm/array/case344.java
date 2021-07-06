package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/7/5 16:17
 */
public class case344 {
    public static void main(String[] args) {
        char[] chars = {'H','a','n','n','a','h'};//   'h', 'e', 'l', 'l', 'o'};
        new case344().reverseString(chars);

        System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
    }

    public void reverseString(char[] s) {
        int n = s.length;
        if (n==0){
            return;
        }
        int p = 0 ,q= n-1;
        while(p<=q){
            if(s[q]==s[p]){
                p++;q--;
                continue;
            }
            char c = s[q];
            s[q]= s[p];
            s[p] = c;
            q--;
            p++;
        }

    }
}
