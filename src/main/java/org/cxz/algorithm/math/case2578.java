package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/9 10:55
 */
public class case2578 {
    public int splitNum(int num) {
        String a = "",b = "";
        int[] cnt = new int[10];
        int x = num, n=0;
        while(x>0){
            cnt[x%10]++;
            x/=10;
            n++;
        }
        int base =1;
        for(int i = 9,j=0;i>=0;i--){
            while(cnt[i]>0){
                if(j%2==0) a = i+a;
                else b = i+b;
                cnt[i]--;
                j++;
            }
        }
        Integer v1 = Integer.parseInt(a);
        Integer v2 = Integer.parseInt(b);
        return v1+v2;
    }
}
