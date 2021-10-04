package org.cxz.algorithm.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/1 18:06
 */
public class case313 {
    public static void main(String[] args) {
        int[] p = new int[]{2,7,13,19};

        int res = new case313().nthSuperUglyNumber(12,p);
        System.out.println("res = " + res);

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] p = new int[primes.length];
        List<Integer> data = new ArrayList<>();
        data.add(1);
        int ans = 1;// Initial value whatever it is, but not too small
        while(data.size()<n){
            ans = data.get(p[0])*primes[0];// ans must be seted in every loop
            for(int i=1;i<primes.length;i++){
                ans = Math.min(ans, data.get(p[i])*primes[i]);
            }
            for (int i = 0; i < primes.length; i++) {
                if(data.get(p[i])*primes[i]==ans){
                    p[i]++;
                }
            }
            data.add(ans);
        }
        return ans;
    }


}
