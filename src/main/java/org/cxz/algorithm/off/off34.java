package org.cxz.algorithm.off;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/11 11:00
 */
public class off34 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {

    }
    public List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<Integer> track = new ArrayList<>();
        dfs(track,root,target);
        return ans;
    }
    public void dfs(List<Integer> track, TreeNode root, int tar){
        if(root==null ){
            return;
        }
        if(root!=null&&root.val==tar&&isleaf(root)){
            track.add(root.val);
            ans.add(new ArrayList<>(track));
            track.remove(track.size()-1);
            return;
        }
        track.add(root.val);
        int t = tar -root.val;
        dfs(track,root.left,t);
        dfs(track,root.right,t);
        track.remove(track.size()-1);
        return ;
    }

    public boolean isleaf(TreeNode r){
        return r.right==null&&r.left==null;
    }
}
