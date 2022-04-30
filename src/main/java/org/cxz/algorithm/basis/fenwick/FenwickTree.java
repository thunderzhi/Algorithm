package org.cxz.algorithm.basis.fenwick;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/27 17:29
 */
public class FenwickTree {

    public int[] C;

    //biggest index
    public int n;

    public FenwickTree(int size){
        C = new int[size+1];
        n = size;
    }

    public int lowbit(int x){
        return x&(-x);
    }

    public void add(int i ,int x){
        while(i<=n){
            C[i] +=x;
            i = i+lowbit(i);
        }
        return;
    }

    //s[i] = s[i-lowbit(i)] +c[i]
    public int query(int i){
        int sum =0;
        while(i>0){
            sum += C[i];
            i = i -lowbit(i);
        }
        return sum;
    }
    //get original index array value
    public int getIndVal(int i){
        if(i==0){
            return 0;
        }
        return query(i)- query(i-1);
    }
}
