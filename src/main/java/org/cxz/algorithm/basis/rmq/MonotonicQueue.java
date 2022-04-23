package org.cxz.algorithm.basis.rmq;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/19 12:37
 */
public class MonotonicQueue {

    /*this is No-Increasing monotonic queue
    for get the MAX value of the array and window size is k*/
    public int[] MonotonicNoIncreasing(int[] nums,int k){
        int n = nums.length;
        Deque<Integer> qu = new LinkedList<>();
        List<Integer> ans = new ArrayList();
        for(int i=0;i<n;i++){
            while(!qu.isEmpty()&&nums[i]>nums[qu.peekLast()]){
                qu.pollLast();
            }
            qu.offerLast(i);
            if(i-qu.peekFirst()==k){
                qu.pollFirst();
            }
            if(i+1<k) continue;
            ans.add(nums[qu.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /*this is No-Decreasing monotonic queue
    for get the MIN value of the array and window size is k*/
    public int[] MonotonicNoDecreasing(int[] nums,int k){
        int n = nums.length;
        Deque<Integer> qu = new LinkedList<>();
        List<Integer> ans = new ArrayList();
        for(int i=0;i<n;i++){
            while(!qu.isEmpty()&&nums[i]<nums[qu.peekLast()]){
                qu.pollLast();
            }
            qu.offerLast(i);
            if(i-qu.peekFirst()==k){
                qu.pollFirst();
            }
            if(i+1<k) continue;
            ans.add(nums[qu.peekFirst()]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
