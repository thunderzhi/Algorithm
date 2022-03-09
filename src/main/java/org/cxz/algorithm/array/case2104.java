package org.cxz.algorithm.array;

import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/9 20:48
 */
public class case2104 {

    public long getValue(LinkedList<Integer> maxq, LinkedList<Integer> minq, int[] nums){
        int maxn = maxq.size();
        int minn = minq.size();
        int pre_pos = -1;
        long ans =0;
        int p = 0,q = 0;
        int i =0 ,j =0;
        while(i!=maxq.size()){
            p = maxq.get(i);
            q = minq.get(j);
            int pos = Math.min(p,q);//index
            ans += (long)(pos-pre_pos)*(long)(nums[p]-nums[q]);
            if(p==pos){
                i++;
            }
            if(q==pos){
                j++;
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
