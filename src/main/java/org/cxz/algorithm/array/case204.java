package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/27 23:51
 */
public class case204 {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        int[] prime = new int[n+1];
        for (int i = 2; i*i < n; i++) {
            if (prime[i]==1){
                continue;
            }
            for (int j = 2*i; j < n; j+=i) {
                prime[j]=1;
            }
        }
        int cnt =0;
        for (int i = 2; i < n; i++) {
            if (prime[i]==0){
                cnt+=1;
            }
        }
        return cnt;
    }
}
