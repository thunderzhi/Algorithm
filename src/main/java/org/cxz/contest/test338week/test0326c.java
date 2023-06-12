package org.cxz.contest.test338week;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/26 10:31
 */
public class test0326b {
    static int[] prime;
    public static int Eulerprime(int n){
        prime = new int[n+1];
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

    public static void main(String[] args) {
        int cnt = 101;
        int eulerprime = Eulerprime(cnt);
        System.out.println("eulerprime " +eulerprime);
        System.out.println(" = " + Arrays.toString(prime));
    }
    public boolean primeSubOperation(int[] nums) {
        int max = 0,n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max,nums[i]);
        }
        int m = Eulerprime(max);
        // prime 1~ m;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=1;i<=m;i++){
            tm.put(prime[i],i);
        }
        int pre  = 0;
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if(pre >= cur){
                ans = false;
                break;
            }
            if(cur<2){
                pre = cur;
            }
            else{
                //cur >=2
                // 1 not change pre = cur
                // 2 substract cur - p > pre try to find p ,if not exist goto 1
                // cur - pre > p   ,  p should <(cur -pre)
                //
                // cur - p> pre
                int d = cur - pre;
                Integer f = tm.floorKey(d - 1);
                if(f==null){
                    pre = cur;
                    continue;
                }
                int diff =0;
                for(int j = 1;j<=m;j++){
                    int p = prime[j];
                    if(p>f) break;
                    if(cur -p<= pre) break;
                    if(cur - p>pre){
                        diff = p;
                    }
                }
                pre = cur - diff;
            }
        }
        return ans;
    }
}
