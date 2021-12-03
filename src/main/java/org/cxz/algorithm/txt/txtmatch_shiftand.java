package org.cxz.algorithm.txt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/3 22:31
 */
public class txtmatch_shiftand {
    public static void main(String[] args) {
        String txt = "aecaeaecaedc";
        System.out.println("txt length = " + txt.length()    );
        String pattern = "aecaed";
        System.out.println("pattern length = " + pattern.length()    );
        int res = new txtmatch_shiftand().shift_and(txt, pattern);
        System.out.println("res = " + res);
    }

    public int getNextP(char ch,int[] code ,int p){
        return (p<<1|1)&code[ch];
    }
    public int shift_and(String txt,String pattern){
        int[] code =new int[256];
        int n=0;
        for (n = 0; n < pattern.length(); n++) {
            code[pattern.charAt(n)]|=(1<<n);
        }
        int p =0;
        for (int i = 0; i < txt.length(); i++) {
            p = getNextP(txt.charAt(i),code,p);
            if ((p&(1<<(n-1)))!=0){
                return i-n+1;
            }
        }
        return -1;
    }
}
