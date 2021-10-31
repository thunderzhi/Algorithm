package org.cxz.algorithm.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/31 11:18
 */
public class case862 {
    public static void main(String[] args) {

    }


    public int shortestSubarray(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        sum[0] =0;
        for(int i =0;i<nums.length;i++){
            sum[i+1] = sum[i]+nums[i];
        }
        Deque<Integer> dq = new LinkedList<>();
        dq.offer(0);//ind of sum;
        int pos = -1; int ans = -1;
        for(int i =1;i<sum.length;i++){
            while(!dq.isEmpty()&&(sum[i]-sum[dq.peek()])>=k){
                pos = dq.peekFirst();
                dq.pollFirst();
            }
            if(pos!=-1&&(i-pos<ans||ans==-1)){
                ans = i-pos;
            }
            while(!dq.isEmpty()&&(sum[i]-sum[dq.peekLast()])<0){

                dq.pollLast();//find new i
            }
            dq.offer(i);

        }
        return ans;
    }
}
