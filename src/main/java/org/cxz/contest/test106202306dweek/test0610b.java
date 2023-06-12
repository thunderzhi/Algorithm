package org.cxz.contest.test106202306dweek;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/27 22:38
 */
public class test0610b {
    public boolean check(int[] arr,int a){
        while(a>0){
            int m = a%10;
            if(arr[m]>0) return false;
            arr[m]++;
            a = a/10;
        }
        return true;
    }
    public boolean isFascinating(int n) {
        String s1 = String.valueOf(n);
        int[] cnt = new int[10];
        int x = n,y = 2*n,z = 3*n;
        check(cnt,x);
        check(cnt,y);
        check(cnt,z);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);
        System.out.println("cnt = " + Arrays.toString(cnt));
        if(cnt[0]!=0) return false;
        for (int i = 1; i < 10; i++) {
            if(cnt[i]!=1)return false;
        }
        return true;
    }
}
