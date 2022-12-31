package org.cxz.algorithm.basis.graph.struct;

/**
 * @author cxz
 * @Title: 邻接矩阵
 * @Package
 * @Description: this structure take too much space 稠密图
 * @date 2022/12/31 15:28
 */
public class AdjacencyMatrix {
    int N;// N is node of graph

    // 邻接矩阵数组：w[a][b] = c 代表从 a 到 b 有权重为 c 的边
    int[][] w = new int[N][N];

    // 加边操作
    void add(int a, int b, int c) {
        w[a][b] = c;
    }
}
