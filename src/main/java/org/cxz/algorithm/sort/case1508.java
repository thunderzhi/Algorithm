package org.cxz.algorithm.sort;

import java.util.PriorityQueue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/12 17:40
 */
public class case1508 {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        int i = new case1508().rangeSum(arr, 4, 1, 5);
        System.out.println(i);
    }
    public class Data{
        public int i;//index
        public int j;//index
        public int sum;//sum

        public Data(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Data> q = new PriorityQueue<>(((o1, o2) -> {
            return o1.sum - o2.sum;
        }));
        for (int i = 0; i < n; i++) {
            q.offer(new Data(i,i,nums[i]));
        }
        int ans = 0;
        int mod = 1000000007;
        for (int i = 1; i <= right; i++) {
            Data d = q.peek();
            q.poll();
            if(i>=left){
                ans = (ans + d.sum)%mod;
            }
            if(d.j+1<n){
                q.offer(new Data(d.i,d.j+1,(d.sum+nums[d.j+1])%mod));
            }
        }
        return ans;
    }
}
