package org.cxz.algorithm.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/4 11:35
 */
public class case907 {
    public static void main(String[] args) {

        int res = new case907().sumSubarrayMins(new int[]{11,81,94,43,3});
        System.out.println("res = " + res);
    }
    // monotonic increase
    public int sumSubarrayMins(int[] arr) {
        long[] sum = new long[arr.length+1];
        long mod = (long)(1e9+7);
        Deque<Integer> st = new LinkedList<>();
        int ans =0;
        for (int i=0;i<arr.length;i++){
            while(!st.isEmpty()&&arr[i]<=arr[st.peekLast()]){
                st.pollLast();
            }
            int ind = st.isEmpty()? -1:st.peekLast();
            System.out.println("-----------------" );
            System.out.println(" arr["+i+"] = "+arr[i] );

            System.out.println("Small ele = " + (ind==-1?-1:arr[ind]));
            st.offerLast(i);
            System.out.println(" step = " + (i-ind));
            int n = st.size();
            sum[st.size()] = (sum[st.size()-1]+arr[i]*(i-ind))%mod;
            System.out.println("sum["+(n-1)+"] = " + sum[n-1]);
            System.out.println("sum["+ n +"] = " + sum[n]);

            ans +=sum[st.size()];
            ans %=mod;
        }
        return ans;
    }
}
