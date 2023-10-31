package org.cxz.algorithm.dp;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/31 14:09
 */
public class case2003 {

    Map<Integer, List<Integer>> g = new HashMap<>();
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = nums.length, cur = -1;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        // 找节点 1, 建图
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) cur = i;
            List<Integer> list = g.getOrDefault(parents[i], new ArrayList<>());
            list.add(i);
            g.put(parents[i], list);
        }

        // 若 nums 中没 1, 对应结论一
        if (cur == -1) return ans;

        boolean[] vis = new boolean[n + 10];
        // 从节点 1 开始往根找（从深到浅）, idx 代表当前节点, ne 代表 cur 在该链路下的子节点
        int ne = cur, val = 1;
        while (cur != -1) {
            // 每次对当前节点所在子树的进行标记
            dfs(cur, ne, nums, vis);
            // 在 [val, n+1] 范围内找第一个未被标记基因值
            for (int i = val; i <= n + 1; i++) {
                if (vis[i]) continue;
                ans[cur] = val = i;
                break;
            }
            ne = cur; cur = parents[cur]; // 指针上移
        }
        return ans;
    }
    void dfs(int idx, int block, int[] nums, boolean[] vis) {
        vis[nums[idx]] = true;
        List<Integer> list = g.getOrDefault(idx, new ArrayList<>());
        for (int x : list) {
            if (x == block) continue;
            dfs(x, block, nums, vis);
        }
    }
}
