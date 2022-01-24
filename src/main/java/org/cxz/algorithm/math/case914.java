package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/24 23:39
 */
public class case914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] cnt = new int[10000];

        for(int i = 0;i<deck.length;i++){
            cnt[deck[i]]+=1;
        }
        int ans =-1;
        for(int i = 0;i<cnt.length;i++){
            if(cnt[i]==0){
                continue;
            }
            if(ans ==-1){
                ans = cnt[i];
            }
            else{
                ans = gcd(ans,cnt[i]);
            }
            if(ans==1) break;
        }
        return ans>=2;
    }


    public int gcd(int a,int b){
        if(b>0){
            return gcd(b,a%b);
        }
        return a;
    }
}
