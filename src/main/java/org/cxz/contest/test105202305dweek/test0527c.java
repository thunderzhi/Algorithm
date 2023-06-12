package org.cxz.contest.test105202305dweek;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/27 22:38
 */
public class test0527b2 {

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        boolean[][] arr = new boolean[n+1][n+1];
        Set<String> set = new HashSet<>();
        for (String dic:dictionary) {
            set.add(dic);
            int l = 0;
            while(l<n){
                l = s.indexOf(dic,l);
                if(l==-1) break;
                int len = dic.length();
                // r-l+1 =len
                int r = len-1+l;
                arr[l][r] = true;
                System.out.println(" l = " + l+"r = " + r+ " is "+arr[l][r]+" "+dic);
                l = r+1;
            }
            if(l==-1)continue;
        }
        int[] f = new int[n];
        //  f[i] = f[i-1]+(arr[i][i]==true)?1:0
        int max =0;
        for (int i = 0; i < n; i++) {

            if(arr[0][i])f[i] = i+1;
            if(i>0)f[i] = Math.max(f[i],f[i-1]);
            for (int j = 0; j < i; j++) {

                if(arr[j+1][i]){
                    int len = i-j;
                    f[i] =Math.max(f[i],f[j]+len);
                }
                System.out.println(" f["+i+"] = " + f[i]);

                max = Math.max(max,f[i]);
            }
        }
        System.out.println("max = " + max);
        return n-max;

    }
}
