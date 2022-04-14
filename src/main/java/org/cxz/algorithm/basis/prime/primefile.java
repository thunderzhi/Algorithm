package org.cxz.algorithm.basis.prime;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: all prime <=n
 * @date 2022/4/14 11:36
 */
public class primefile {
    // O nloglogn
    public int Eratosthenes(int n){
        int[] prime = new int[n + 1];
        for (int i = 2; i*i <= n; i++) {
            if (prime[i] == 1) {
                continue;
            }
            for (int j = i *i; j <= n; j+=i) {
                prime[j] = 1;
            }
        }
        for (int i = 2; i <=n; i++) {
            if (prime[i]==0) {
                prime[0]++;
            }
        }
        return prime[0];
    }

    // On
    //欧拉筛
    public int Eulerprime(int n){
        int[] prime = new int[n+1];
        for(int i=2;i<=n;i++){
            if(prime[i]==0){
                prime[++prime[0]] = i;
            }
            for(int j = 1;j<=prime[0];j++){
                if(prime[j]*i>n) break;
                prime[prime[j]*i]=1;
                if(i%prime[j]==0) break;
            }
        }
        return prime[0];
    }
}
