package org.cxz.algorithm.unionfind;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 10:43
 */
public class UnionSet {
    public int n;
    public int[] fa;
    UnionSet(int nums){
        fa = new int[nums+1];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
    }
    int get(int x){
        return fa[x] = fa[x]==x ? x:get(fa[x]);
    }
    void merge(int a,int b){
        fa[get(a)]= get(b);
    }
}
