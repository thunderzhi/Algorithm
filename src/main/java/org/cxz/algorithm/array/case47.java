package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/23 0:07
 */
public class case47 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<Integer> tracklist = new LinkedList<>();
        ans = new ArrayList<>();
        int[] visit = new int[nums.length];
        Arrays.sort(nums);//sort
        dfs(tracklist,0,nums,visit);
        return ans;
    }

    public void dfs(LinkedList<Integer> track,int ind,int[] nums,int[] visit){
        if(ind==nums.length){
            ans.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visit[i]==1||(i>0&&nums[i]==nums[i-1]&&visit[i-1]==0)){
                continue;
            }
            track.addLast(nums[i]);
            visit[i] =1;
            dfs(track,ind+1,nums,visit);
            track.removeLast();
            visit[i] =0;
        }
        return;
    }

}
