package org.cxz.algorithm.queue;

import com.sun.corba.se.impl.orbutil.threadpool.WorkQueueImpl;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/31 16:08
 */
public class case1438 {
    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums, int limit) {
        return bs(nums,1,nums.length,limit);
    }
    public int bs(int[] nums,int l,int r ,int limit){
        if(l==r){
            return l;
        }
        int mid = (l+r+1)>>1;
        if(check(nums,mid,limit)){
            l = mid;

        }
        else{
            r=mid-1;
        }
        return bs(nums,l,r,limit);

    }

    public boolean check(int[] nums, int k, int limit) {
        Deque<Integer> qmin = new LinkedList<>();
        Deque<Integer> qmax = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while(!qmin.isEmpty()&&nums[i]<nums[qmin.peekLast()]){
                qmin.pollLast();
            }
            while(!qmax.isEmpty()&&nums[i]>nums[qmax.peekLast()]){
                qmax.pollLast();
            }
            qmax.offer(i);
            qmin.offer(i);
            if(i+1<k){
                continue;
            }
            if(i-qmin.peekFirst()==k){
                qmin.pollFirst();
            }
            if(i-qmax.peekFirst()==k){
                qmax.pollFirst();
            }
            if(nums[qmax.peek()]-nums[qmin.peek()]<=limit){
                return true;
            }
        }
        return false;
    }

}

