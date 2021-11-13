package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/13 10:40
 */
public class caseO0406 {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode pre;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return root;
        }
        pre =null;
        return inorder(root,p);
    }
    public TreeNode inorder(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        }
        TreeNode t = inorder(root.left,p);
        if (t!=null) {
            return t;
        }
        if(p==pre){
            return root;
        }
        pre = root;
        t =inorder(root.right,p);
        if (t!=null) {
            return t;
        }
        return null;
    }
}