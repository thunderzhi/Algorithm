package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/28 11:15
 */
public class case2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int m = flowers.length;
        TreeMap<Integer,Integer> tm = new TreeMap();
        for(int[] fl: flowers){
            tm.put(fl[0], tm.getOrDefault(fl[0],0)+1);
            tm.put(fl[1]+1, tm.getOrDefault(fl[1]+1,0)-1);
        }
        Integer[] ind = new Integer[n];
        for(int i=0;i<n;i++){
            ind[i] = i;
        }
        Arrays.sort(ind,(a, b)->{
            return people[a] -people[b];
        });
        int id = 0;
        List<int[]> arr = new ArrayList();
        for(int k : tm.keySet()){
            int v = tm.get(k);
            int[] it = new int[]{k,v};
            arr.add(it);
        }
        int cnt = 0,pre = 0,idx = 0,len = arr.size();
        int[] ans = new int[n];

        for(int i = 0;i<n;i++){
            int t = people[ind[i]];
            while(idx<len&& arr.get(idx)[0]<=t){
                cnt += arr.get(idx)[1];
                idx++;
            }
            ans[ind[i]] = cnt;
        }
        return ans;
    }
}
