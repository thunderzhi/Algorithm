package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 16:37
 */
public class case124 {
    public int sum  = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getmax(root);
        return sum;
    }

    public int getmax(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = Math.max(getmax(root.left),0);
        int r = Math.max(getmax(root.right),0);
        sum = Math.max(sum, root.val+l+r);
        return root.val+ Math.max(l,r);
    }
}
