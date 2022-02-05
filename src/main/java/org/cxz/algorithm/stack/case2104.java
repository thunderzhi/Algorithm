package org.cxz.algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/4 20:45
 */
public class case2104 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        long ans = new case2104().subArrayRanges(arr);
        System.out.println(ans);
    }

    /// not pass
    public long getValue(LinkedList<Integer> maxq, LinkedList<Integer> minq, int[] nums){
        int maxn = maxq.size();
        int minn = minq.size();
        int pre_pos = -1;
        long ans =0;
        int p = 0,q = 0;//p --->min
        while(p<minn){
            int pos = Math.min(p,q);//index
            ans += (long)(pos-pre_pos)*(long)(nums[q]-nums[p]);
            if(p==pos){
                p++;
            }
            if(q==pos){
                q++;
            }
            pre_pos = pos;
        }
        return ans;
    }
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> maxq = new LinkedList<Integer>();
        LinkedList<Integer> minq = new LinkedList<Integer>();
        long ans = 0;
        for(int i=0;i<n;i++){
            while(!maxq.isEmpty()&&nums[maxq.peekLast()]<=nums[i]){
                maxq.pollLast();
            }
            while(!minq.isEmpty()&&nums[minq.peekLast()]>=nums[i]){
                minq.pollLast();
            }
            minq.offerLast(i);
            maxq.offerLast(i);
            ans += getValue(maxq,minq,nums);
        }
        return ans;
    }
}
