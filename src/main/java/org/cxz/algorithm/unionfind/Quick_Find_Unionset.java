package org.cxz.algorithm.unionfind;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/20 22:09
 */
public class Quick_Find_Unionset {
    public int[] color;
    public int n;

    Quick_Find_Unionset(int n){
        color = new int[n+1];
        for (int i = 0; i <= n; i++) {
            color[i]=i;
        }
    }

    int find(int x){
        return color[x];
    }

    void merge(int a,int b){
        if(color[a]==color[b]) return;
        int cb = color[b];
        for (int i = 0; i <=n; i++) {
            if(color[i]==cb){
                color[i] =color[a];
            }
        }
        return;
    }
}
