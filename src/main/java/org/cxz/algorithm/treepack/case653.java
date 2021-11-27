package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/27 21:44
 */
public class case653 {
    public static void main(String[] args) {

    }
    public List<Integer> ret;
    public boolean findTarget(TreeNode root, int k) {
         ret = new ArrayList<>();
         int l =0;
         int r = ret.size()-1;
         while(l<r&&(ret.get(l)+ret.get(r)-k)!=0){
             if(ret.get(l)+ret.get(r)>k){
                 r--;
             }
             else {
                 l++;
             }
         }
         return l<r;
    }

    public void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        ret.add(root.val);
        inorder(root.right);
        return;
    }

}
