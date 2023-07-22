package org.cxz.algorithm.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/7/22 15:56
 */
public class case918 {

    //单调队列
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length,sum =0,ans = Integer.MIN_VALUE;
        // idx --- val
        Deque<int[]> dq = new ArrayDeque();
        dq.offerLast(new int[]{0,0});
        for(int i=0;i<2*n-1;i++){
            sum += nums[i%n];
            while(!dq.isEmpty()
                    &&(i-dq.peekFirst()[0])>n-1){
                dq.pollFirst();
            }
            if(dq.peekFirst()[0]==n)break;
            if(!dq.isEmpty()){
                ans = Math.max(ans,sum -dq.peekFirst()[1]);
            }
            while(!dq.isEmpty()&&dq.peekLast()[1]> sum){
                dq.pollLast();
            }
            dq.offerLast(new int[]{i,sum});
        }
        return ans;
    }
}
