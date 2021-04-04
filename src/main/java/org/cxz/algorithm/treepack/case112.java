package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/4 15:53
 */
public class case112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&root.right==null){
            return targetSum==root.val;
        }
        boolean l = hasPathSum(root.left,targetSum-root.val);
        boolean r = hasPathSum(root.right,targetSum-root.val);
        return l||r;
    }
}
