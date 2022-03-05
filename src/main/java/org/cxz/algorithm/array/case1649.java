package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/5 16:14
 */
public class case1649 {

    class FenwickTree{
        int[] c;
        int n;
        public FenwickTree(int n) {
            this.c = new int[n + 1];
            this.n = n;
        }

        private int lowbit(int i) {
            return i & (-i);
        }

        public int sum(int i, int j) {
            return query(j) - query(i);
        }

        public void add(int i, int x) {
            while (i <= n) {
                c[i] += x;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int n = 0;
            while (i > 0) {
                n += c[i];
                i -= lowbit(i);
            }
            return n;
        }


    }
    public int createSortedArray(int[] instructions) {
        int max = Arrays.stream(instructions).max().getAsInt();
        long ans = 0;
        long mod = (long) (1e9 + 7);
        FenwickTree tree = new FenwickTree(max + 1);
        for (int i = 0; i < instructions.length; i++) {
            tree.add(instructions[i], 1);
            ans += Math.min(tree.query(instructions[i] - 1),
                    tree.sum(instructions[i], max));
        }
        return (int) (ans%mod);
    }
}
