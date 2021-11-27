package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/26 15:09
 */
public class case99 {
    public static void main(String[] args) {

    }
    TreeNode pre;
    TreeNode p;
    TreeNode q;
    public void recoverTree(TreeNode root) {
        pre = q = p =null;
        inorder(root);
        if(p!=null&&q!=null){
            swap(p,q);
            return;
        }
    }
    public void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        if (pre!=null&&pre.val>root.val){
            if(p==null){
                p = pre;
            }
            q = root;
        }
        pre =root;
        inorder(root.right);
        return;
    }

    public void swap(TreeNode a,TreeNode b){
        int tmp =a.val ;
        a.val= b.val;
        b.val =tmp;
    }
}
