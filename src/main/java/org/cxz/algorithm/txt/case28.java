package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/7 14:18
 */
public class case28 {
    public static void main(String[] args) {

    }
    public void getnext(String patt, int[] next){
        int length = patt.length();
        next[0]=-1;
        for ( int i = 1,j=-1; i < length ; i++) {
            while(j!=-1&& patt.charAt(i)!=patt.charAt(j+1)){
                j = next[j];
            }
            if (patt.charAt(i)==patt.charAt(j+1)){
                j+=1;
            }
            next[i] = j;
        }
        return ;
    }

    public int kmm(String txt, String patt){
        int[] next = new int[patt.length()];
        getnext(patt,next);
        for (int i = 0,j=-1; i <txt.length() ; i++) {
            while (j!=-1&&txt.charAt(i)!=patt.charAt(j+1)){
                j=next[j];
            }
            if (txt.charAt(i)==patt.charAt(j+1)) {
                j+=1;
            }
            if (patt.length() ==j+1){
                return i-j;
            }
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if(needle==null||"".equals(needle)){
            return 0;
        }
        return kmm(haystack,needle);
    }
}
