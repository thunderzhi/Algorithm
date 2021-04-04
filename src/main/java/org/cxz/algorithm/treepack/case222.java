package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/4 15:55
 */
public class case222 {

    public int countNodes(TreeNode root) {
        if(root==null){return 0;}
        return countNodes(root.right)+countNodes(root.left)+1;
    }
}
