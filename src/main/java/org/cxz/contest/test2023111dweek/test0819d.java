package org.cxz.contest.test2023111dweek;

import org.cxz.algorithm.linkedlist.ListNode;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/19 22:28
 */
public class test0819c {
    List<Integer> arr;
    int INF;
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        arr = nums;
        INF = Integer.MAX_VALUE;
        if(n==1) return 0;
        boolean isorder = true;
        for (int i = 1; i < n; i++) {
            if(nums.get(i)<nums.get(i-1)){
                isorder= false;
                break;
            }
        }
        if(isorder) return 0;
        int res = dfs(n-1,-1,0);
        return res;
    }
    // idx th set last
    public int dfs(int idx,int last,int cnt){
        if(idx<0) return cnt;
        int cur = arr.get(idx);
        int res = INF;
        if(last==-1){
            // could chose 1 2 3
            for (int i = 1; i <= 3; i++) {
                res = Math.min(res,dfs(idx-1,i,cnt+ (i!=cur?1:0)));
            }
        }
        else{
            // last!=-1
            for (int i = 1; i <= last; i++) {
                res = Math.min(res,dfs(idx-1,i,cnt+ (i!=cur?1:0)));
            }
        }
        return res;
    }
}
