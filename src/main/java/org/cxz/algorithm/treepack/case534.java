package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/17 23:40
 */
public class case534 {
    public int ans ;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root){
        if(root==null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        System.out.println(" root: "+root.val + " dep: "+(Math.max(left,right)+1)+" L+R: "+(left+right));
        ans = Math.max(ans,left+right);
        return Math.max(left,right)+1;
    }
}
