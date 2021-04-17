package org.cxz.algorithm.dynamic;

import org.cxz.algorithm.treepack.TreeNode;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/17 14:16
 */
public class caseO54 {
    public int getcount(TreeNode root){
        if(root == null){
            return 0;
        }
        int r=0 ,l =0;
        if(root.right!=null){
            r = getcount(root.right);
        }
        if(root.left!=null){
            l = getcount(root.left);
        }
        return l+r+1;
    }
    public int kthLargest(TreeNode root, int k){
        if(root == null){
            return 0;
        }
        int cnt =  getcount(root.right);
        if(k ==cnt+1){
            return root.val;
        }
        if(k<=cnt){
            return kthLargest(root.right,k);
        }
        return kthLargest(root.left,k-cnt-1);
    }
}
