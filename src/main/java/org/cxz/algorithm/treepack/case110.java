package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/4 15:49
 */
public class case110 {
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        if(l<0||r<0){
            return -2;
        }
        if(Math.abs(l-r)>1){
            return -2;
        }

        return Math.max(l,r)+1;

    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root)>=0;

    }
}
