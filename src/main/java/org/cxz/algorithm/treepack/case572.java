package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 12:27
 */
public class case572 {

    //ver dfs
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null) return true;
        if(root==null||subRoot==null) return false;
        if(root.val==subRoot.val&&match(root,subRoot)){
            return true;
        }
        return isSubtree(root.right,subRoot)
                ||isSubtree(root.left,subRoot);
    }

    public boolean match(TreeNode root, TreeNode subRoot){
        if(root==null&&subRoot==null) return true;
        if(root==null||subRoot==null) return false;
        if(root.val!=subRoot.val) return false;
        return  match(root.right,subRoot.right)&& match(root.left,subRoot.left);
    }
}
