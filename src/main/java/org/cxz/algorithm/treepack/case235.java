package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 14:58
 */
public class case235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if(root!=null&&root.val<p.val&&root.val<q.val){
                root = root.right;
            }
            else if(root!=null&&root.val>p.val&&root.val>q.val){
                root = root.left;
            }
            else{
                break;
            }

        }
        return root;
    }


}
