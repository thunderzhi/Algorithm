package org.cxz.algorithm.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/23 17:02
 */
public class case491 {


    // ver1 cap
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        dfs(nums,0,0,new LinkedList(),ans);
        return ans;
    }

    public void dfs(int[] nums,int ind,int k,LinkedList<Integer> track, List<List<Integer>> ans){
        // System.out.println("k: "+k+"   track size: "+track.size()+" --");
        if(track.size()>1){
            // System.out.println("track: "+track.toString());
            ans.add(new ArrayList(track));
        }
        if(k==nums.length) return;
        int[] mark = new int[205];
        for(int i= ind;i<nums.length;i++){
            if(mark[nums[i]+101]==1) continue;
            if(track.size()==0||track.get(track.size()-1)<=nums[i]){
                // System.out.println("k: "+k+"  add num["+i+"]: "+nums[i]);
                track.add(nums[i]);
                mark[nums[i]+101] =1;
                dfs(nums,i+1,k+1,track,ans);
                track.removeLast();
                //  System.out.println("remove track: "+track.toString());
            }
        }
        //System.out.println("k:"+k+" end --");
        return;
    }

    //ver 2 assit
    public void dfs2(int[] nums,int ind,LinkedList<Integer> track, List<List<Integer>> ans){
        if(track.size()>1){
            ans.add(new ArrayList(track));
        }
        if(ind==nums.length) return;
        int[] mark = new int[205];
        for(int i= ind;i<nums.length;i++){
            if(mark[nums[i]+101]==1) continue;
            if(track.size()==0||track.get(track.size()-1)<=nums[i]){
                track.add(nums[i]);
                mark[nums[i]+101] =1;
                dfs2(nums,i+1 ,track,ans);
                track.removeLast();
            }
        }
        return;
    }
}
