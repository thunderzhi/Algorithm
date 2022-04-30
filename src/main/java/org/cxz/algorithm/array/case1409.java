package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/29 10:52
 */
public class case1409 {
    class FenwickTree {

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
//        public int getIndVal(int i){
//            if(i==0){
//                return 0;
//            }
//            return query(i)- query(i-1);
//        }
    }
    //ver 1 fenwicktree
    public int[] processQueries(int[] queries, int m) {
        int[] pos = new int[m + 1];
        int len = queries.length;
        FenwickTree tree = new FenwickTree(queries.length + m);
        for (int i = 1; i <= m; i++) {
            tree.add(len + i, 1);
            pos[i] = len + i;
        }
        int[] res = new int[len];//miss
        for (int i = 0; i < len; i++) {
            int ind = pos[queries[i]];
            res[i] = tree.query(ind) - 1;//miss
            tree.add(ind, -1);
            tree.add(len - i, 1);
            pos[queries[i]] = len - i;
        }
        return res;
    }

}
