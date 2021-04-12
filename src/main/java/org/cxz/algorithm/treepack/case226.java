package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/12 19:26
 */
public class case226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        if(root.right!=null){
            invertTree(root.right);
        }
        if(root.left!=null){
            invertTree(root.left);
        }
        return root;
    }
}
