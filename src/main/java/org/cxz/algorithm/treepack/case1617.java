package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/13 17:12
 */
public class case1617 {
    private List<Integer>[] g;
    private int mask, vis, diameter;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0] - 1, y = e[1] - 1; // 编号改为从 0 开始
            g[x].add(y);
            g[y].add(x); // 建树
        }

        int[] ans = new int[n - 1];
        // 二进制枚举
        for (mask = 3; mask < 1 << n; ++mask) {
            if ((mask & (mask - 1)) == 0) continue; // 需要至少两个点
            vis = diameter = 0;
            dfs(Integer.numberOfTrailingZeros(mask)); // 从一个在 mask 中的点开始递归
            if (vis == mask){
                ++ans[diameter - 1];
            }
        }
        return ans;
    }

    // 求树的直径
    private int dfs(int x) {
        vis |= 1 << x; // 标记 x 访问过
        int maxLen = 0;
        for (int y : g[x]){
            if ((vis >> y & 1) == 0 && (mask >> y & 1) == 1) { // y 没有访问过且在 mask 中
                int ml = dfs(y) + 1;
                diameter = Math.max(diameter, maxLen + ml);
                maxLen = Math.max(maxLen, ml);
            }
        }
        return maxLen;
    }
}
