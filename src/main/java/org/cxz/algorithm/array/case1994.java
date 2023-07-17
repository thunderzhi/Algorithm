package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/17 14:31
 */
public class case1994 {

    int MOD = (int)1e9+7; 
    static int[] prime = new int[31];
    static boolean[] notprime = new boolean[31];  
    static{              
        for (int i = 2; i <= 30; i++) {
            if (notprime[i]) continue;
            prime[++prime[0]] = i;            
            for (int j = i*i; j <= 30; j+=i) {
                notprime[j]=true;
            }
        }
        //prime is :  2 3 5 7 11 13 17 19 23 29    
    }

    public int numberOfGoodSubsets(int[] nums) {
        int[] map = new int[31];
        for(int num: nums){
            map[num]++;
        }
        long pow1 =1;
        if(map[1]>0) pow1 = pow(2L,map[1]);
        int[] fac = new int[31];
        int cnt =0;
        for(int i=1,j=0;i<31;i++) {
            if (map[i] == 0) continue;
            //System.out.println("i "+ i);
            if (i == 1) {
                fac[i] = 1; 
                continue;
            }
            int x = i, mask = 0;
            boolean flag = true;
            while (x > 1) {
                for (int k = 1; k <= prime[0]; k++) {
                    if ((x % prime[k]) != 0) continue;
                    if ((mask & (1 << (prime[k]-1))) != 0) {
                        flag = false;
                        break;
                    }
                    mask |= (1 << (prime[k]-1));
                    x /= prime[k];                    
                }        
                if (!flag) break;        
            }
            if (!flag) continue;
            fac[i] = mask; 
            cnt++;
        }
        //return 0;
        int[] arr = new int[cnt];
        for (int i = 2, j = 0; i < 31; i++) {
            if (fac[i] == 0) continue;
            arr[j++] = i;
        } 
        int u = (1<<cnt)-1;
        int state = u;
        long tot =0;
        for(int sub = state;sub>0;sub = (sub-1)&state){
            boolean flag = true; 
            long count = 1;int mask = 0;
            for(int i=0;i<cnt;i++){
                if(((sub>>i)&1)==0) continue; 
                if(Integer.bitCount(mask|fac[arr[i]])!=(Integer.bitCount(mask)+Integer.bitCount(fac[arr[i]]))){
                    flag = false;
                    break;
                }
                mask|= fac[arr[i]];
                count %= MOD;
                count = (count*map[arr[i]])%MOD;
            }
            if(!flag) continue; 
            if(map[1]>0){
                count = (count*pow1)%MOD;
            }
            tot = (tot%MOD+ count%MOD)%MOD;
        }
        return (int)tot;
    }
    public int pow(long x,long n){
        x %= MOD;
        long res = 1;
        while (n > 0) {
            if ((n & 1)==1) res = (res * x) % MOD;
            x = (x  * x) % MOD; 
            n >>>= 1;
        }
        res %=MOD; 
        return (int)res; 
    } 
}
