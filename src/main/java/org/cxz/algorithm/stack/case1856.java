package org.cxz.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/3 17:57
 */
public class case1856 {
    public static void main(String[] args) {

    }

    //monotonic increase stack
    public int maxSumMinProduct(int[] nums) {
        long[] sum = new long[nums.length+1];
//        long mod = 1000000007;
        long mod =(long)(1e9+7);
        sum[0]=0;
        for(int i=0;i<nums.length;i++){
            sum[i+1]= sum[i]+nums[i];
        }
        int[] l = new int[nums.length];
        Arrays.fill(l,-1);
        int[] r = new int[nums.length];
        Arrays.fill(r,nums.length);
        Deque<Integer> st = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while(!st.isEmpty()&& nums[i]<=nums[st.peekLast()]){
                r[st.peekLast()] =i;
                st.pollLast();
            }
            if(!st.isEmpty()){
                l[i] = st.peekLast();
            }
            st.offerLast(i);
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {

            long a = nums[i] * (sum[r[i]] - sum[l[i]+1]);
            ans = Math.max(ans,a);
        }

        return (int)(ans%mod);

    }
}
