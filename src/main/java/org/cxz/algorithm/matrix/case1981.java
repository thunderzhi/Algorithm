package org.cxz.algorithm.matrix;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/14 11:50
 */
public class case1981 {
    // ver1 hashset
    public int minimizeTheDifference1(int[][] mat, int target) {
        HashSet<Integer>[] sets = new HashSet[2];
        sets[0] = new HashSet<Integer>();
        sets[1] = new HashSet<Integer>();
        int n = mat.length, sum = 0;
        for (int x : mat[0]) {
            sets[0].add(x);
            sum = Math.max(sum, x);
        }
        for (int i = 1; i < n; i++) {
            int ind = i & 1, pre_ind = ind ^ 1;
            sets[ind].clear();
            int max_num = 0;
            for (int x : mat[i]) max_num = Math.max(max_num, x);
            sum += max_num;
            for (int j = i + 1; j <= sum; j++) {
                for (int x : mat[i]) {
                    if (!sets[pre_ind].contains(j - x)) continue;
                    sets[ind].add(j);
                    break;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Integer x : sets[(n - 1) % 2]) ans = Math.min(ans, Math.abs(target -x));
        return ans;
    }


    // ver2 dfs
    public int ans;
    public int[][] vis;
    public int minimizeTheDifference2(int[][] mat, int target) {
        vis = new int[70][10000];
        ans= Integer.MAX_VALUE;
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++) Arrays.sort(mat[i]);
        dfs(mat,0,target);
        return ans;
    }

    public void dfs(int[][] mat,int ind, int target){
        if(ind == mat.length){
            ans = Math.min(ans,Math.abs(target));
            return;
        }
        int[] arr = mat[ind];
        if(target<0&&target*(-1)>=ans) return;
        for(int i = 0;i<arr.length;i++){
            int cur = arr[i];
            int abs = target-cur;
            if(vis[ind][abs+5000]==1) continue;
            dfs(mat,ind+1,target-cur);
            vis[ind][abs+5000] =1;
        }
        return;
    }

    //ver 3
    public int minimizeTheDifference3(int[][] mat, int target) {
        boolean[] f = new boolean[target];
        f[0] = true;
        int large=Integer.MAX_VALUE;
        for(int i=0; i<mat.length; i++){
            boolean[] g = new boolean[target];
            int last_large = Integer.MAX_VALUE;
            for(int x:mat[i]){
                for(int j=0; j<target; j++){
                    if(f[j]){
                        if(j+x >= target){
                            last_large = Math.min(last_large,j+x);
                        }
                        else{
                            g[j+x] = true;
                        }
                    }
                }
                if(large != Integer.MAX_VALUE){
                    last_large = Math.min(last_large,large+x);
                }
            }
            f = g;
            large = last_large;
        }
        int ans = Math.abs(large - target);
        for(int i= target -1;i>=0;i--){
            if(f[i]){
                ans = Math.min(ans,target-i);
                break;
            }
        }
        return ans;
    }
}
