package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/10 22:47
 */
public class case687 {

    public int max =0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root){
        if(root==null) {
            return 0;
        }
        int l = dfs(root.left);
        // System.out.println("root: "+root.val+" l: "+l+" r: "+r);
        int r = dfs(root.right);
        int left = 0,right = 0;
        if(root.left!=null&&root.left.val==root.val){
            left = 1+l;
        }
        if(root.right!=null&&root.right.val==root.val){
            right = r+1;
        }
        //System.out.println("root: "+root.val+" l: "+l+" r: "+r);
        max = Math.max(right+left,max);

        return Math.max(right,left);
    }
}
