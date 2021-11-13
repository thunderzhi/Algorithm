package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/13 20:53
 */
public class caseO1712 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }

    public void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        if(pre ==null){
            pre = root;
            ret.right = root;
        }
        else{
            pre.right = root;
            pre = root ;
        }
        pre.left =null;
        inorder(root.right);
        return;
    }
    public TreeNode pre;
    public TreeNode ret;
    public TreeNode convertBiNode(TreeNode root) {
        ret = new TreeNode(0);
        ret.left = null;
        pre = null;

        inorder(root);
        return ret.right;
    }
}
