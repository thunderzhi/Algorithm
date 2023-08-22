package org.cxz.contest.test20230820359week;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/20 10:30
 */
public class test0820b {
    int ans = 1<<30;
    int INF = 1<<30;
    int _k,_n;
    public int minimumSum(int n, int k) {
        // 1 ~ m  total n
        _k=k;
        _n=n;
        int res = dfs(1,new HashSet<>(),0,0);
        return ans;
    }

    public int dfs(int idx, Set<Integer> set, int cnt,int s){
        if(cnt>=_n){
            ans = Math.min(ans,s);
            return ans;
        }
        if(s>=ans) return INF;
        int res = INF;
        //not chose
       // int t = dfs(idx+1,set,cnt,s);
       // res = Math.min(res,t);
        // chose idx
        if(set.contains(_k-idx)){
            // cant chose idx ,change another
            int nx = idx;
            while(set.contains(_k-nx)) nx++;
            // nx can be chosen
            set.add(nx);
            s+=nx;
            int t2 = dfs(nx+1,set,cnt+1,s);
            s-=nx;
            set.remove(nx);
            res = Math.min(res,t2);
        }
        else{
            set.add(idx);
            s += idx;
            int t2 = dfs(idx+1,set,cnt+1,s);
            s -= idx;
            set.remove(idx);
            res = Math.min(res,t2);
        }
        return res ;
    }


}
