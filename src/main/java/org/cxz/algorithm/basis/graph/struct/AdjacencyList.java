package org.cxz.algorithm.basis.graph.struct;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title: 邻接表
 * @Package
 * @Description:
 * @date 2022/12/31 15:32
 */
public class AdjacencyList {
    int N,M;//N represent nums of node ,M represent nums of edge
    List<List<Integer[]>> list;
    public AdjacencyList(){
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        // list.get(i)  从i节点可以到达与i相邻的节点 列表
        // int[] t = list.get(i).get(j)  t[0] 表示相邻的节点，t[1]表示 边的权值
    }

    // 邻接表 变形 链式前向星
    int[] he = new int[N];// 节点 i 出发的所有边的集合， he[i] 为 这个集合的头结点，即边的编号
    int[] W = new int[M];// 编号i的边 权值为 W[i]
    int[] e = new int[M];// 编号i的边 指向的 节点 e[i]
    int[] next = new int[M];// next[i] 是用来遍历he[a] 边集合的。

    int idx;// 边的 编号
    //节点a 到达节点b，权值是c
    void add(int a, int b, int c) {
        e[idx] = b;//
        next[idx] = he[a];
        he[a] = idx;
        W[idx] = c;
        idx++;
    }
    //遍历 从节点a出发的所有边
    void get(int a){
        for (int i = he[a]; i != -1; i = next[i]) {
            int b = e[i], c = W[i]; // 存在由 a 指向 b 的边，权重为 c
        }
    }

}
