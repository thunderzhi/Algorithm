package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/15 16:31
 */
public class case1175 {

    public int numPrimeArrangements(int n) {
        int cntprime = init_prime(n);
        return (int)(frac(cntprime)*frac(n-cntprime)%mod);
    }

    public long frac(int n){
        long ans = 1;
        for(int i=2;i<=n;i++ ){
            ans = ans*i%mod;
        }
        return ans;
    }

    public final int max =105;
    public final long mod = (long)(1e9+7);

    public int [] mu = new int[max+5];
    public int [] prime = new int[max+5];

    int init_prime(int n){
        mu[1]=1;
        for (int i = 2; i <= n; i++) {
            if(prime[i]==0){
                prime[++prime[0]]= i;
                mu[i]=-1;
            }
            for (int j = 1; j <= prime[0]; j++) {
                if(i*prime[j]>n){
                    break;
                }
                prime[i* prime[j]]=1;
                if(i*prime[j]==0){
                    break;
                }
                mu[i*prime[j]]=-mu[i];
            }
        }
        return prime[0];
    }
}
