package org.cxz.contest.test20231224377week;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/12/24 10:29
 */
public class test1224 {

    public int[] numberGame(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.sort(nums);
        int idx = 0;
        for (int i = 0; i <n-1; i+=2) {
            int a = nums[i], b = nums[i+1];
            arr[idx++] = b;
            arr[idx++] = a;
        }
        return arr;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        long mod = (long)(1e9)+7;
        Set<Long> set1 = calc(hFences,m);
        Set<Long> set2 = calc(vFences,n);
        long len = 0, mx = -1;
        for(long s1: set1){
            if(s1<=len)continue;
            if(set2.contains(s1)){
                len = s1;
                mx = len*len;
            }
        }
        return (int)(mx%mod);
    }

    private Set<Long> calc(int[] a,int end){
        Arrays.sort(a);
        int n = a.length;
        int m = n+1;
        int[] arr = new int[m];
        arr[0] = a[0]- 1;
        for (int i = 1; i < m; i++) {
            if(i<n) arr[i] = a[i]-a[i-1];
            else arr[i] = end - a[i-1];
        }
        System.out.println("arr = " + Arrays.toString(arr) );
        Set<Long> set = new HashSet<>();
        long[] sum = new long[m+1];
        for (int i = 0; i < m; i++) {
            sum[i+1] = sum[i] + arr[i];
            System.out.println("add = " + sum[i+1]);
            if(sum[i+1]>0) set.add(sum[i+1]);
        }
        for (int i = 1; i <=m; i++) {
            long x = sum[i];
            for (int j = i+1; j <=m ; j++) {
                long cur = sum[j] - sum[i];
                System.out.println("add cur= " + sum[i+1]);
                if(cur>0) set.add(cur);
            }
        }
        return set;
    }
    long[][] g,dis;
    long INF;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        g = new long[26][26];
        dis = new long[26][26];
        INF = Long.MAX_VALUE/2;
        for (int i = 0; i < 26; i++) {
            Arrays.fill(g[i],INF);
            Arrays.fill(dis[i],INF);
        }
        int len = original.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len ; i++) {
            int x = original[i]-'a',y = changed[i]-'a',v = cost[i];
            g[x][y] = v;
            set.add(x);
        }
        for(int it: set){
            dis[it] = dj(it);
        }
        int n = source.length();
        long ans =0;
        for (int i = 0; i < n; i++) {
            int a = source.charAt(i)-'a', b = target.charAt(i)-'a';
            if(a==b) continue;
            if(dis[a][b]==INF) return -1;
            ans += dis[a][b];
        }
        return ans;



    }

    public long[] dj(int id){
        long[] dis = new long[26];
        Arrays.fill(dis,INF);
        dis[id] = 0;
        boolean[] vis = new boolean[26];
        // id  dis
        PriorityQueue<Long[]> pq = new PriorityQueue<Long[]>((a,b)->{return a[1].compareTo(b[1]);});
        pq.offer(new Long[]{(long)id,0L});
        vis[id] = true;
        while(!pq.isEmpty()){
            Long[] t = pq.poll();
            long idx = t[0], step = t[1];
            for (int i = 0; i < 26; i++) {
                if(i==idx||g[(int)idx][i]==INF) continue;
                if(vis[i]) continue;
                if(dis[i]>= step + g[(int)idx][i]) continue;
                dis[i] = step + g[(int)idx][i];
                vis[i] = true;
                pq.offer(new Long[]{(long)i,dis[i]});
            }
        }
        return dis;
    }

}
