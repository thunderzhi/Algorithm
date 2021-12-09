package org.cxz.algorithm.txt;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/8 16:26
 */
public class txtpaliddrome_manacher {

    public static void main(String[] args) {
        String s = "babad";
        String manacher = new txtpaliddrome_manacher().manacher(s);
        System.out.println("manacher = " + manacher);

    }

    public String getNew(String s){
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)+"#");
        }
        return sb.toString();
    }

    public String manacher(String s){
        String ns = getNew(s);
        int[] d= new int[ns.length()];
        int l = 0 ,r = -1;
        for (int i = 0; i < ns.length(); i++) {
            if (i>r){
                d[i] =1;
            }
            else {
                d[i] = Math.min(r-i,d[l+r-i]);
            }
            System.out.println("l = " + l+" r = " + r);
            //while (i-d[i]>=0&&i+d[i]<ns.length()&&ns.charAt(i-d[i])==ns.charAt(i+d[i])){
            while (i-d[i]>=0&&ns.charAt(i-d[i])==ns.charAt(i+d[i])){
                d[i]++;
                System.out.println(ns);
                System.out.println("Arrays.toString(d) = " + Arrays.toString(d));

                System.out.println("i = " + i);
                System.out.println("(i-d[i]) = " + (i-d[i]));
                System.out.println("(i+d[i]) = " + (i+d[i]));
                System.out.println("=================== " );
            }
            if (i+d[i]>r&&i-d[i]>0){
                l = i-d[i];
                r = i+ d[i];
            }

        }
        StringBuilder ret =new StringBuilder();
        int tmp = -1;
        int ind =0;
        for (int i = 0; i < ns.length(); i++) {
            if(tmp>=d[i]){
                continue;
            }
            tmp = d[i];
            ind = i;
        }
        for (int i = ind - tmp + 1; i < ind+tmp; i++) {
            if(ns.charAt(i)=='#'){
                continue;
            }
            ret.append(ns.charAt(i));
        }
        return ret.toString();
    }


}
