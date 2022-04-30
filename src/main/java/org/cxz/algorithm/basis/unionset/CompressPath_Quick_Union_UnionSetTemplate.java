package org.cxz.algorithm.basis.unionset;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: This template include path compress,for common
 * @date 2022/4/30 10:28
 */
public class CompressPath_Quick_Union_UnionSetTemplate {
    int[] fa;

    public CompressPath_Quick_Union_UnionSetTemplate(int n){
        fa = new int[n+1];
        for (int i = 0; i <=n ; i++) {
            fa[i] =i;
        }
        return;
    }

    public int get(int x){
        return fa[x]=(fa[x]==x?x:get(fa[x]));
//        if(fa[x]==x) return x;
//        return fa[x] = get(fa[x]);
    }

    public void merge(int a,int b){
        fa[get(a)]=get(b);
//        int aa = get(a), bb = get(b);
//        if(aa== bb) return;
//        fa[aa] =bb;
        return;
    }
}
