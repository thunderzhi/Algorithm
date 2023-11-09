package org.cxz.algorithm.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/9 21:22
 */
public class case2258 {

    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    int n, m;
    boolean ok;
    int[][] g, fg, pg;
    public int maximumMinutes(int[][] grid) {
        g = grid;
        n = g.length; m = g[0].length;
        fg = new int[n][m]; pg = new int[n][m];
        if (!check(0)) return -1;
        int l = 0, r = n * m;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return r == m * n ? (int)1e9 : r;
    }
    boolean check(int t) {
        ok = false;
        Deque<int[]> fire = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fg[i][j] = pg[i][j] = 0;
                if (g[i][j] == 1) {
                    fg[i][j] = 1;
                    fire.addLast(new int[]{i, j});
                }
            }
        }
        while(t-- > 0) update(fire, true, 0);  // 先执行 t 秒的火势蔓延
        if (fg[0][0] != 0) return false;
        Deque<int[]> people = new ArrayDeque<>();
        pg[0][0] = 1;
        people.addLast(new int[]{0, 0});
        while (!people.isEmpty()) {
            // 先火后人, 同步进行
            update(fire, true, 1);
            update(people, false, 1);
            if (ok) return true;
        }
        return false;
    }
    void update(Deque<int[]> deque, boolean isFire, int offset) {
        int sz = deque.size();
        while (sz-- > 0) {
            int[] info = deque.pollFirst();
            int x = info[0], y = info[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (g[nx][ny] == 2) continue;
                if (isFire) {
                    if (fg[nx][ny] != 0) continue;
                    fg[nx][ny] = fg[x][y] + offset;
                } else {
                    if (nx == n - 1 && ny == m - 1 && (fg[nx][ny] == 0 || fg[nx][ny] == pg[x][y] + offset)) ok = true;  // 火尚未到达 或 同时到达
                    if (fg[nx][ny] != 0 || pg[nx][ny] != 0) continue;
                    pg[nx][ny] = pg[x][y] + offset;
                }
                deque.addLast(new int[]{nx, ny});
            }
        }
    }
}
