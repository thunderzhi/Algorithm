package org.cxz.algorithm.basis.unionset;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/29 18:11
 */
public class Quick_Union_UnionsetTemplate {

    public int[] fa;
    public int n;

    Quick_Union_UnionsetTemplate(int n){
        fa = new int[n+1];
        for (int i = 0; i <= n; i++) {
            fa[i]=i;
        }
    }

    int find(int x){
        if(fa[x]==x){
            return x;
        }
        return find(fa[x]);
    }

    void merge(int a,int b){
        int ra = find(a);
        int rb = find(b);
        if(ra == rb){
            return;
        }
        fa[ra] = rb;
        return;
    }
}
