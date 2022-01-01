package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/1 10:49
 */
public class case307 {
    public class NumArray{

        public int[] C;
        public int n;

        public int lowbit(int i){
            return i&(-i);
        }
        public void add(int i ,int val){
            while(i<=n){
                C[i]+=val;
                i=i+lowbit(i);
            }
            return;
        }

        public int query(int i){
            int sum =0;
            while(i>0){
                sum += C[i];
                i= i-lowbit(i);
            }
            return sum;
        }

        public NumArray(int[] nums) {
            n = nums.length;
            C = new int[n+1];
            for (int i = 1; i <=n; i++) {
                add(i,nums[i-1]);
            }
        }
        public int getN(int i ){
            return query(i)-query(i-1);
        }

        public void update(int index, int val) {
            add(index+1,val- getN(index+1));
        }

        public int sumRange(int left, int right) {
            int a = query(left);
            int b = query(right+1);//miss +1
            return b-a;
        }
    }

}
