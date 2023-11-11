package org.cxz.algorithm.graph;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/11 15:03
 */
public class case765 {

    class USet{
        int[] fa;
        USet(int size){
            fa = new int[size];
            for(int i = 0;i<size;i++)  fa[i] = i;
        }
        int getFa(int x){
            if(fa[x]== x) return x;
            return getFa(fa[x]);
        }
        void add(int a,int b){
            int pa = getFa(a);
            int pb = getFa(b);
            if(pa==pb) return ;
            fa[pb] = pa;
            return;
        }
    }
    public int minSwapsCouples(int[] row) {
        int m = row.length, n = m/2;
        USet uset = new USet(n);
        for(int i = 0;i<n;i++){
            int id = 2*i;
            int a = row[id], b= row[id+1];
            uset.add(a/2,b/2);
        }
        int cnt = 0;

        for(int i=0;i<n;i++) if(uset.fa[i]==i) cnt++;
        return n - cnt;
    }
}
