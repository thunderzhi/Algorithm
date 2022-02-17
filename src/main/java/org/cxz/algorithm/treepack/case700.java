package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/17 23:51
 */
public class case700 {

    // 迭代
    public TreeNode searchBST1(TreeNode root, int val) {
        TreeNode ans = null;
        TreeNode p = root;
        while(p!=null){
            if(p.val == val){
                return p;
            }
            if(p.val > val){
                p = p.left;
            }
            else{
                p = p.right;
            }
        }
        return ans;
    }
    
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return root;
        if(root.val ==val) return root;
        if(root.val>val) return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
}
