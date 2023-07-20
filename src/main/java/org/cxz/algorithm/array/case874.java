package org.cxz.algorithm.array;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: 
 * @date 2023/7/20 10:27
 */
public class case874 {
    int INF = Integer.MAX_VALUE;
    // binarysearch
    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer,List<Integer>> mapx = new HashMap();
        Map<Integer,List<Integer>> mapy = new HashMap();
        for(int [] obs :obstacles){
            int x = obs[0],y = obs[1];
            List<Integer> xlist = mapx.getOrDefault(x,new ArrayList());
            List<Integer> ylist = mapy.getOrDefault(y,new ArrayList());
            xlist.add(y);
            ylist.add(x);
            mapx.put(x,xlist);
            mapy.put(y,ylist);
        }
        for(int k : mapx.keySet()){
            List<Integer> list = mapx.get(k);
            Collections.sort(list);
            mapx.put(k,list);
        }
        for(int k : mapy.keySet()){
            List<Integer> list = mapy.get(k);
            Collections.sort(list);
            mapy.put(k,list);
        }
        int d = 0; // direction
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};// N,E,S,W

        int n = commands.length;
        int idx = 0,cx = 0,cy = 0,ans=0;
        while(idx<n){
            int c = commands[idx];
            if(c<0){
// System.out.println("idx "+idx +" update d: "+d );
                if(c==-2) d = (d+3)%4;
                else d = (d+1)%4;
// System.out.println("idx "+idx +" update to d: "+d );
            }
            else{
                int nx = cx+ dir[d][0]*c;
                int ny = cy+ dir[d][1]*c;
                int obs = INF;
                if(d%2==0){
                    // N S
                    if(d==0){
                        if(mapx.containsKey(cx)){
                            obs = find1(mapx.get(cx),cy);
                        }
                        if(obs!=INF&&obs<=ny){
                            ny = obs-1;
                        }
                    }
                    else{
                        if(mapx.containsKey(cx)){

                            obs = find2(mapx.get(cx),cy);
// System.out.println("cx "+cx+" cy "+cy +" list "+mapx.get(cx).toString()+" obs "+obs);
                        }
                        if(obs!=INF&&obs>=ny){
                            ny = obs+1;
                        }
                    }

                    // find x = cx,
                    //if d==0 find first obsy>cy and obsy<=ny
                    // then ny = obsy-1. else ny keep
                    // if d==2 find first obsy <cy and obsy>=ny
                    // then ny = obsy +1 ,else ny keep

                    // calc  nx^2+ ny^2
                    //

                }
                else{
                    // E W
                    if(d==1){
                        if(mapy.containsKey(cy)){
                            obs = find1(mapy.get(cy),cx);
                        }
                        if(obs!=INF&&obs<=nx){
                            nx = obs-1;
                        }
                    }
                    else{
                        if(mapy.containsKey(cy)){

                            obs = find2(mapy.get(cy),cx);
                        }
                        if(obs!=INF&&obs>=nx){
                            nx = obs+1;
                        }
                    }
                }
// System.out.println("idx "+idx +" nx "+nx +" ny "+ny);
                int res = nx*nx + ny*ny;
                ans = Math.max(ans,res);
                cx = nx; cy = ny;

            }
            idx++;
        }
        return ans;
    }
    // find first > tar
    public int find1(List<Integer> list,int tar){
        if(list.size()==0
                ||list.get(list.size()-1)<tar) return INF;
        if(list.get(0)>tar) return list.get(0);
        int n = list.size();
        // 0~n-1
        int l = 0,r = n-1,mid = 0;
        while(l<r){
            mid = l+(r-l)/2;
            if(list.get(mid)>tar) r = mid;
            else l = mid+1;
        }
        return list.get(l)>tar?list.get(l):INF;
    }
    // find first < tar
    public int find2(List<Integer> list, int tar){
        if(list.size()==0
                ||list.get(0)>tar) return INF;
        int n = list.size();
        if(list.get(n-1)<tar) return list.get(n-1);
        // 0~n-1
        int l = 0,r = n-1,mid = 0;
        while(l<r){
            mid = l+(r-l+1)/2;
            if(list.get(mid)>=tar) r = mid-1;
            else l = mid;
        }
//System.out.println(" l "+l +" : list[l]: "+list.get(l));
        return list.get(l)<tar?list.get(l):INF;
    }

    //hash
    public int robotSim2(int[] commands, int[][] obstacles) {
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int px = 0, py = 0, d = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        int res = 0;
        for (int c : commands) {
            if (c < 0) {
                d += c == -1 ? 1 : -1;
                d %= 4;
                if (d < 0) {
                    d += 4;
                }
            } else {
                for (int i = 0; i < c; i++) {
                    if (set.contains((px + dirs[d][0]) * 60001 + py + dirs[d][1])) {
                        break;
                    }
                    px += dirs[d][0];
                    py += dirs[d][1];
                    res = Math.max(res, px * px + py * py);
                }
            }
        }
        return res;
    }
}
