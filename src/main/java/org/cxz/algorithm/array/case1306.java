package org.cxz.algorithm.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/15 11:31
 */
public class case1306 {

    
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        Queue<Integer> queue = new LinkedList();
        queue.offer(start);
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i=0;i<length;i++){
                int ind = queue.poll();
                dp[ind] = 1;//visited
                if(arr[ind]==0) return true;
                int left =ind- arr[ind];
                if(left>=0&&left<n&&dp[left]==-1){
                    queue.offer(left);
                }
                int right =ind+ arr[ind];
                if(right>=0&&right<n&&dp[right]==-1){
                    queue.offer(right);
                }
            }
        }
        return false;
    }
}
