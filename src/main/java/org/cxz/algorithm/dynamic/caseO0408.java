package org.cxz.algorithm.dynamic;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/13 10:45
 */
public class caseO0408 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args) {

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
//        if(root.val==p.val||root.val==q.val){
//            return root;
//        }
        if(root==p||root==q){
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l!=null&&l!=null){
            return root;
        }
        if (l!=null&&r==null){
            return l;
        }
        return r;
    }


}
