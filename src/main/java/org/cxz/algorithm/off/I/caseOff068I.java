package org.cxz.algorithm.off.I;

import org.cxz.algorithm.treepack.TreeNode;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/1 23:40
 */
public class caseOff068I {

    //ver 1
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        while(true){
            if(root.val>Math.max(p.val,q.val)){
                root = root.left;
            }
            else if(root.val<Math.min(p.val,q.val)){
                root = root.right;
            }
            else if(root.val == p.val||root.val == q.val){
                break;
            }
            else{
                break;
            }
        }
        return root;
    }

    //ver 2
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        return find(root,p,q);
    }

    public TreeNode find(TreeNode root,TreeNode p,TreeNode q){
        if(root.val == p.val||root.val == q.val) return root;
        if(root.val<Math.max(p.val,q.val)&&root.val>Math.min(p.val,q.val)) return root;
        if(root.val>Math.max(p.val,q.val)){
            return find(root.left,p,q);
        }
        return find(root.right,p,q);//(root.val>Math.max(p.val,q.val))
    }
}
