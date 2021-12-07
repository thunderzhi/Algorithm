package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/7 17:18
 */
public class case459 {
    public static void main(String[] args) {
        String s = "abcabcabc";
        boolean b = new case459().repeatedSubstringPattern(s);
        System.out.println("b = " + b);
    }
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int[] next = new int[n];
        getNext(s,next);
        int l =n - next[n-1]-1;
        return next[n-1]!=-1&&(n%l==0);
    }

    public void getNext(String pattern,int[] next){
        next[0] = -1;
        for (int i = 1,j=-1; i < pattern.length(); i++) {
            while (j!=-1&&pattern.charAt(i)!=pattern.charAt(j+1)){
                j= next[j];
            }
            if (pattern.charAt(i)==pattern.charAt(j+1)){
                j+=1;
            }
            next[i] = j;
        }
        return ;
    }

}
