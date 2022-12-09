package org.cxz.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/9 14:39
 */
public class case1780 {
    public static void main(String[] args) {
        case1780 case1780 = new case1780();
        int n = 91;
        boolean b = case1780.checkPowersOfThree(n);
        System.out.println("b = " + b);
    }
    public boolean checkPowersOfThree(int n) {
        if(n==1) return true;
        List<Integer> list = new ArrayList();
        list.add(1);
        int cnt = 1,t=(int)Math.pow(3,cnt);
        while(t<=n){
            if(t==n) return true;
            list.add(t);
            cnt++;
            t = (int)Math.pow(3,cnt);
        }
        int len = list.size();
        //System.out.println(len);


        int[] f = new int[1<<len];
        for(int i=0;i<len;i++){
            f[1<<i] = list.get(i);
            System.out.println("init 1<<i = " + Integer.toBinaryString(1<<i)+" "+list.get(i) );
        }

        for(int i=0;i<len;i++){
            System.out.println("i ---------------= " + i);
            for(int j =1;j<f.length;j++){
                //System.out.println("j = " + j);
                int ind = (1<<i);
                int tmp = (j|ind);
                System.out.println("j = "+j+" AND j bit= " + Integer.toBinaryString(j));
                System.out.println("==1<<i bit= " + Integer.toBinaryString(ind));
                System.out.println("==tmp Bit = " + Integer.toBinaryString(tmp));
                System.out.println("==tmp = " + tmp);
                if(f[j]!=0 && f[j|(1<<i)]==0){
                    f[j|(1<<i)] = list.get(i) + f[j];
                    System.out.println("SET f["+tmp+"] = " + f[tmp]);

                    if(f[j|(1<<i)]==n) return true;
                }

            }
        }


        return false;
        // f[i][j] =f[i-1][j]| f[i-1][j-a[i-1]]; j>=a[i-1];
        // for(int i=1;i<=len;i++){
        //     int num = list.get(i-1);
        //     for(int j = 0;j<=n;j++){
        //         boolean no = f[i-1][j];
        //         boolean y = j>=num?f[i-1][j-num]:false;
        //         f[i][j] = no|y;
        //     }
        // }
        // return f[len][n];
    }
}
