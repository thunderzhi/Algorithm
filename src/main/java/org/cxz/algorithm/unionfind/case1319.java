package org.cxz.algorithm.unionfind;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 22:49
 */
public class case1319 {

    public static void main(String[] args) {

    }
    public int makeConnected(int n, int[][] connections) {
        if(n>connections.length){
            return -1;
        }
        UnionSet u = new UnionSet(n);
        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0];
            int b = connections[i][1];
            u.merge(a,b);
        }
        int ans =0;
        for (int i = 0; i < n; i++) {
            if(u.get(i)==i){
                ans+=1;
            }
        }
        return ans-1;


    }
}
