package org.cxz.algorithm.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/26 10:03
 */
public class case1993 {
    ArrayList<Integer>[] g;
    int[] mlock,fa;
    int n;
    public case1993(int[] parent) {
        n = parent.length;
        fa = parent;
        g = new ArrayList[n];
        mlock = new int[n];
        for(int i =0;i<n;i++){
            g[i] = new ArrayList();
            mlock[i] =-1;
        }
        for(int i = 1;i<n;i++){
            int p = parent[i];
            g[p].add(i);
        }
    }

    public boolean lock(int num, int user) {
        if(mlock[num]>=0) return false;
        mlock[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if(mlock[num]!=user) return false;
        mlock[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        boolean flag = true;
        if(mlock[num]>=0) return false;
        int x = num;
        while(x>=0&&fa[x]>=0){
            if(mlock[fa[x]]>=0){
                return false;
            }
            x = fa[x];
        }
        List<Integer> list = new ArrayList();
        dfs(num, fa[num], list );
        if(list.size()==0) return false;
        for(int y: list){
            mlock[y] = -1;
        }
        mlock[num] = user;
        return true;
    }
    public void dfs(int cur ,int fa,List<Integer> list){
        List<Integer> t = g[cur];
        if(mlock[cur]>=0){
            list.add(cur);
        }
        for(int x: t){
            if(x== fa) continue;
            dfs(x,cur,list);
        }
        return;
    }
}
