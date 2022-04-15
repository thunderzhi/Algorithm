package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/14 12:50
 */
public class case2165 {

    public long smallestNumber(long num) {
        if(num==0) return 0;
        int flag =1;
        if(num<0) {
            flag = -1;
            num = -num;
        }
        int[] cnt = new int[10];
        while(num>0){
            cnt[(int)(num%10)] +=1;
            num/=10;
        }
        long ans =0;
        if(flag ==1){
            for(int i =1;i<10;i++){
                if(cnt[i]==0) continue;
                ans = i;
                cnt[i]--;
                break;
            }
        }
        for(int i = (flag==1?0:9),I = 9-i;i*flag<=I;i+=flag){
            for(int j =0;j<cnt[i];j++){
                ans = ans*10 + i;
            }
        }
        return ans*flag;
    }
}
