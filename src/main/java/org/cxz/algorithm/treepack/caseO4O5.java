package org.cxz.algorithm.treepack;

import org.cxz.DataStructures.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/19 19:39
 */
public class caseO4O5 {
 
    public boolean isValidBST(TreeNode root) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        List<TreeNode> inorder = inorder(root,ans);
        for (int i = 0; i < inorder.size(); i++) {

            if(inorder.get(i).val>inorder.get(i+1).val){
                return false;
            }
        }
        return true;
    }

    public List<TreeNode> inorder(TreeNode root,List<TreeNode> ans){
        if(root == null){
            return ans;
        }
        inorder(root.left,ans);
        ans.add(root);
        inorder(root.right,ans);
        return ans;
    }
}
