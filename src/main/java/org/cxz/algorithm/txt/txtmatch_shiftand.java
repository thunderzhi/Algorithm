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

        System.out.println("p = " + p+" bit: "+Integer.toBinaryString(p));
        System.out.println("ch = " + ch +"  code["+ch+"] = "+code[ch]+" bit: "+Integer.toBinaryString(code[ch]));
        int res =(p<<1|1)&code[ch];
        System.out.println("getNextP return p = " + res +" bit: "+Integer.toBinaryString(res));

        return res;
    }
    public int shift_and(String txt,String pattern){
        int[] code =new int[256];
        int n=0;
        for (n = 0; n < pattern.length(); n++) {
            int ind = pattern.charAt(n);

            System.out.println("Char: "+pattern.charAt(n)+" ind = " + ind+" bit :"+Integer.toBinaryString(ind));
            System.out.println("code["+ind+"] = " + code[ind]);
            int left = (1<<n);
            System.out.println("1 left move " + n+" =  "+Integer.toBinaryString(left));
            System.out.println("code["+ind+"] | "+left+"  = " +(code[ind]|left)+" bit :"+Integer.toBinaryString(code[ind]|left));
            code[pattern.charAt(n)]|=(1<<n);

            System.out.println("N= "+n+" after code["+ind+"] = "+code[ind]+ " bit :"+Integer.toBinaryString(code[ind]));
        }
        int p =0;
        for (int i = 0; i < txt.length(); i++) {
            System.out.println("************************************* ");
            System.out.println("main ind = " + i);
            p = getNextP(txt.charAt(i),code,p);
            System.out.println("num 1 left " + (n-1)+" bit: "+Integer.toBinaryString((1<<(n-1))));
            if ((p&(1<<(n-1)))!=0){
                return i-n+1;
            }
        }
        return -1;
    }
}
