package org.cxz.contest.test20231203374week;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/12/3 10:19
 */
public class test1203 {

    public List<Integer> findPeaks(int[] mountain) {
        int n = mountain.length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if(mountain[i]>mountain[i+1]&&mountain[i]>mountain[i-1]){
                ans.add(i);
            }
        }
        return ans;

    }


    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins );

        // a     a<x  ,a+1~x






        int t = target,k =0;
        while(t>0){
            t>>=1;
            k++;
        }
        // k 1
        int[] pow = new int[15];
        Map<Integer,Integer> pm = new HashMap<>();
        pow[0]=1;
        pm.put(1,0);
        for (int i = 1; i < 15; i++) {
            pow[i] = pow[i-1]*2;
            pm.put(pow[i],i);
        }
        boolean[] appear = new boolean[15];
        for (int i = 0; i < coins.length; i++) {
            if(pm.containsKey(coins[i])){
                appear[pm.get(coins[i])] = true;
            }
        }
        int l =0, r = k,mid = 0;
        while(l<r){
            mid = (l+r)/2;


        }

        return 1;
    }
}
