package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/2 11:46
 */
public class caseO1010 {

    class StreamRank {
        public int[] C;
        public int n;

        public StreamRank() {
            n = 50001;
            C = new int[n+1];
        }

        public int lowbit(int x){
            return x&(-x);
        }

        public void add(int i,int x){
            while (i<=n){
                C[i]+=x;
                i+= lowbit(i);
            }
            return ;
        }

        public int query(int i){
            int sum =0;
            while(i>0){
                sum += C[i];
                i-=lowbit(i);
            }
            return sum;
        }

        public void track(int x) {
            add(x+1,1);
        }

        public int getRankOfNumber(int x) {
            return query(x+1);
        }
    }




}
