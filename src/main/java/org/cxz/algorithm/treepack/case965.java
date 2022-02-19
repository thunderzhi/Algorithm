package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/19 15:48
 */
public class case965 {

    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        return dfs(root,root.val);
    }

    public boolean dfs(TreeNode root,int val){
        if(root==null) return true;
        if(root.val!=val) return false;
        boolean l = dfs(root.left,val);
        boolean r = dfs(root.right,val);
        return l&&r;
    }
}
