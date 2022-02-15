package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/15 11:17
 */
public class case111 {


    public int min = Integer.MAX_VALUE ;
    public int minDepth(TreeNode root) {
        if(root==null)return 0;
        dfs(root,1);
        return min;
    }

    public void dfs(TreeNode root ,int k){
        if(root == null){
            return ;
        }
        if(k>=min){
            return;// no more dfs
        }
        if(root.left==null&&root.right==null){
            min = Math.min(min,k);
            return;
        }
        //System.out.println("root: "+root.val+" k: "+k);
        dfs(root.left,k+1);
        dfs(root.right,k+1);
        return ;
    }
}
