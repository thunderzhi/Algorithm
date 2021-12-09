package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/8 9:00
 */
public class case214 {

    public static void main(String[] args) {

    }


    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        System.out.println("rev = " + rev);
        String s2 = s+"#" +rev;
        System.out.println("s2 = " + s2);
        int n = s2.length();
        int[] next = new int[n];
        next[0]=-1;
        for (int i =1,j =-1 ; i <n ; i++) {
            while(j!=-1&&s2.charAt(i)!=s2.charAt(j+1)){
                j = next[j];
            }
            if (s2.charAt(i)==s2.charAt(j+1)) {
                j+=1;
            }
            next[i] =j;
        }
        int end = next[n-1]+1;
        String s1 = new StringBuilder(s.substring(end)).reverse().toString();

        return s1+s;
    }
}
