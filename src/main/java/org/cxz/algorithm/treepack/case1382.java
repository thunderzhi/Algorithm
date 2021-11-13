package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/13 15:36
 */
public class case1382 {
    public static void main(String[] args) {

    }
    public List<Integer> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        int l = 0;
        int r = nums.length-1;
        return build(nums,l,r);
    }

    public TreeNode build(int[] num,int l ,int r){
        if(l>r){
            return null;
        }
        int ind = l+(r-l)/2;
        TreeNode root = new TreeNode(num[ind]);
        root.left = build(num,l,ind-1);
        root.right =build(num,ind+1,r);
        return root;
    }

    public void inorder(TreeNode root){
        if(root==null){
            return ;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        return;
    }

    public TreeNode insert(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val==val){
            return root;
        }
        if(root.val>val){
            root.left = insert(root.left,val);
        }
        else{
            root.right = insert(root.right,val);
        }
        return root;
    }
}
