package org.cxz.algorithm.array;

import java.util.TreeSet;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/22 11:15
 */
public class case849 {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int l = -n-1,ans = 0;
        for(int i = 0;i<=n;i++){
            if(i==n){
                ans = Math.max(ans, n-1-l);
                break;
            }
            if(seats[i]==0) continue;
            int dis = (l>=0)?(i-l)/2:i;
            l = i;
            ans = Math.max(ans,dis);
        }
        return ans;
    }

    public int maxDistToClosest2(int[] seats) {
        int n = seats.length;
        TreeSet<Integer> ts = new TreeSet();
        for(int i = 0;i<n;i++){
            if(seats[i]==1)ts.add(i);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            if(seats[i]==0){
                Integer f = ts.floor(i);
                Integer c = ts.ceiling(i);
                int res1 = f!=null?(i-f):n+1;
                int res2 = c!=null?(c - i):n+1;
                ans = Math.max(ans,Math.min(res1,res2));
            }
        }
        return ans;
    }
}
