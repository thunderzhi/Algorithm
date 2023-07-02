package org.cxz.contest.test352week;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/2 10:31
 */
public class test0702b {
    public int[] prime ;
    public int Eulerprime(int n){
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
    public List<List<Integer>> findPrimePairs(int n) {
        Eulerprime(n);
        int tot = prime[0];
        if(tot<=1) return new ArrayList<>();
        List<List<Integer>> ans =new ArrayList<>();
        int l = 1, r = tot;
        while(l<r){
            int tmp = prime[l]+prime[r];
            if(tmp==n){
                List<Integer> list =new ArrayList<>();
                list.add(prime[l++]);
                list.add(prime[r--]);
                ans.add(list);
            }
            else if(tmp>n){
                r--;
            }
            else{
                l++;
            }
        }
        return ans;
    }
}
