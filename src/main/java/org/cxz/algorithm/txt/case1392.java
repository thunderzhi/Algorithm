package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/7 22:38
 */
public class case1392 {
    public static void main(String[] args) {
        String s = "ababab";
        String s1 = new case1392().longestPrefix(s);
        System.out.println("s1 = " + s1);
    }

    public String longestPrefix(String s) {
        int n = s.length();
        int[] next =new  int[n];
        next[0] =-1;
        for (int i = 1,j=-1; i <n ; i++) {
            while(j!=-1&&s.charAt(i)!=s.charAt(j+1)){
                j =next[j];
            }
            if (s.charAt(i)==s.charAt(j+1)) {
                j+=1;
            }
            next[i] =j;
        }
        int end = next[n-1]+1;
        String res = s.substring(0,end);
        return res;
    }
}
