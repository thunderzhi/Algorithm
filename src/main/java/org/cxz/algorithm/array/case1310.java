package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/2 11:32
 */
public class case1310 {
    public class FenWickTree{
        public int[] C;
        public int n;
        public FenWickTree(int size){
            n = size;
            C = new int[n+1];
        }
        public int lowbit(int x){
            return x&(-x);
        }

        public void add(int i ,int x){
            while(i<=n){
                C[i]^=x;
                i= i+lowbit(i);
            }
            return ;
        }

        public int query(int i){
            int sum =0;
            while(i>0){
                sum ^= C[i];
                i = i-lowbit(i);
            }
            return sum;
        }

    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        FenWickTree ft = new FenWickTree(arr.length);
        for (int i = 0; i < arr.length; i++) {
            ft.add(i+1,arr[i]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][1];
            int l = queries[i][0];
            ans[i] = ft.query(r+1)^ft.query(l);
        }
        return ans;
    }

}
