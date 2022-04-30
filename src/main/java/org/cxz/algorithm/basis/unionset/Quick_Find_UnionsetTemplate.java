package org.cxz.algorithm.basis.unionset;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/29 17:31
 */
public class Quick_Find_UnionsetTemplate {

    public int[] color;
    public int n;

    Quick_Find_UnionsetTemplate(int n){
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
