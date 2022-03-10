package org.cxz.algorithm.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/10 12:23
 */
public class case1291 {

    // ver1 imitation math add
    public List<Integer> sequentialDigits1(int low, int high) {
        int num1 = low;
        int cntlow=0;
        while(num1>0){
            num1 /=10;
            cntlow++;
        }
        int num2 = high;
        int cnthigh=0;
        while(num2>0){
            num2 /=10;
            cnthigh++;
        }
        List<Integer> ans = new ArrayList();
        build(cntlow,cnthigh,low,high,ans);
        return ans;
    }

    public void build(int cntlow , int cnthigh, int low, int high, List<Integer> ans){
        int[] step = new int[10];
        step[1]=1;
        int[] orign = new int[10];
        orign[1]=1;
        for(int i=2;i<=9;i++){
            orign[i] = orign[i-1]*10+i;//1,12,123,1234
            step[i] = step[i-1]*10+1;//1,11,111,1111
        }
        for(int i= cntlow;i<=cnthigh;i++){
            if(i==10) break;
            int max = Math.min(high,step[i]*9);
            int num = orign[i];
            while(num<=max){
                // if(num%10==9) break;
                if(num>=low&&num<=high){
                    ans.add(num);
                }
                if(num%10==9) break;
                num+=step[i];
            }
        }
    }


    // ver2 brute simple
    public List<Integer> sequentialDigits2(int low, int high) {
        List<Integer> ans = new ArrayList();
        for(int i=1;i<=9;i++){
            int num = i;
            for(int j=i+1;j<=9;j++){
                num = num*10+j;
                if(num>high) break;
                if(num>=low&&num<=high){
                    ans.add(num);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
