package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/21 20:50
 */
public class caseO53 {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode pre;
    public TreeNode post;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        pre =null;
        post =null;
        return post;
    }

    public boolean inorder(TreeNode root, TreeNode p){
        if(root==null){
            return false;
        }

        if (inorder(root.left,p)) {
            return true;
        }
        if(pre!=null&&pre ==p){
            System.out.println("pre!=null " + pre.val);
            post = root;
            return true;
        }
        System.out.println("pre set  " + root.val);
        pre =root;
        if (inorder(root.right,p)) {
            return true;
        }
        return false;
    }


}
