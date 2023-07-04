package org.cxz.algorithm.math;

import com.sun.scenario.effect.impl.prism.PrMergePeer;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/15 15:16
 */
public class prime01 {

    public static void main(String[] args) {
        int n = 100;
        int res = new prime01().Eratosthenes(n);
        System.out.println("res = " + res);
    }
    public final int max =10000;

    public int [] mu = new int[max+5];
    public int [] prime = new int[max+5];

    void init_prime(int n){
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
                if(i%prime[j]==0){
                    break;
                }
                mu[i*prime[j]]=-mu[i];
            }
        }

        return;
    }

    // calc all prime less or equal n
    // this method only mark prime, and add a part of prime to prime array.
    // so if you want all prime, you should travelsal notprime==false;
    public int Eratosthenes(int n){
        int[] prime = new int[n + 1];
        boolean[] notprime = new boolean[n+1];
        int cnt = 0 ; // prime cnt
        for (int i = 2; i*i <= n; i++) {
            if (notprime[i]) continue;
            prime[cnt++] = i;
            for (int j = i*i; j <= n; j+=i) {
                notprime[j]=true;
            }
        }
        return cnt;
    }

    //欧拉筛
    // prime[0] represent numbers of prime
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
