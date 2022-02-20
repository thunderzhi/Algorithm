package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/21 1:05
 */
public class case1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet();
        for(int x: to_delete) set.add(x);
        List<TreeNode> ans = new ArrayList();
        if(root==null) return ans;
        if(!set.contains(root.val)){
            ans.add(root);
        }
        post(root,set,ans);
        return ans;
    }

    public TreeNode post(TreeNode root,
                         Set<Integer> set,
                         List<TreeNode> ans){
        if(root==null) return root;
        root.left = post(root.left,set,ans);
        root.right = post(root.right,set,ans);
        if(set.contains(root.val)){
            if(root.left!=null) ans.add(root.left);
            if(root.right!=null) ans.add(root.right);
            root=null;
        }
        return root;
    }
}
