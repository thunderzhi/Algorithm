package org.cxz.algorithm.basis.unionset;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:  This include set size ,a little 
 * @date 2022/4/29 18:12
 */
public class Weight_Quick_Union_UnionsetTemplate {
    public int[] fa;
    public int[] size;
    public int n;

    Weight_Quick_Union_UnionsetTemplate(int n){
        fa = new int[n+1];
        size = new int[n+1];
        for (int i = 0; i <= n; i++) {
            fa[i]=i;
            size[i] =1;
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
        if(size[ra]>size[rb]){
            fa[rb]=ra;
            size[ra] += size[rb];
        }
        else{
            fa[ra]=rb;
            size[rb] += size[ra];
        }
        return;
    }
}
