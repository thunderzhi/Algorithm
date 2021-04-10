package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/10 10:57
 */
public class case144 {

    public void preorder(TreeNode root, List<Integer> res){
        if(root == null){
            return ;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
        return ;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res =new ArrayList<Integer>();

        preorder(root,res);
        return res;
    }
}
