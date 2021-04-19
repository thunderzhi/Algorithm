package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/19 19:57
 */
public class case230 {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<TreeNode> ans = new ArrayList<>();
        List<TreeNode> inorder = inorder(root,ans);

        return inorder.get(k-1).val;
    }

    public List<TreeNode> inorder(TreeNode root, List<TreeNode> ans){
        if(root == null){
            return ans;
        }
        inorder(root.left,ans);
        ans.add(root);
        inorder(root.right,ans);
        return ans;
    }
}
