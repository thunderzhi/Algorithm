package org.cxz.algorithm.unionfind;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 22:34
 */
public class case684 {
    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionSet u = new UnionSet(edges.length);
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if(u.get(a)==u.get(b)){
                return edges[i];
            }
            u.merge(a,b);

        }
        return new int[0];
    }
}
