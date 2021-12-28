package org.cxz.algorithm.fenwicktree;

import java.io.PrintStream;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/28 14:38
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

    public void output(){

        for (int i = 1; i <= n; i++) {
            System.out.printf("%5d", i);
        }
        System.out.print("\n");
        System.out.println(" ================================================ " );

        System.out.print("\n");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%5d",C[i]);
        }
        System.out.print("\n");
        for (int i = 1; i <= n; i++) {
            System.out.printf("%5d",getIndVal(i));
        }
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        return;
    }

}
