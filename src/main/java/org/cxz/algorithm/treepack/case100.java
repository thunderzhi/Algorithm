package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 9:43
 */
public class case100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q!=null){
            return false;
        }
        if(p!=null&&q==null){
            return false;
        }
        if(p==null&&q==null){
            return true ;
        }

        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
 
}
