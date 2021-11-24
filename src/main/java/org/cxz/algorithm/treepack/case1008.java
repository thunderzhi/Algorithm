package org.cxz.algorithm.treepack;

import java.util.TreeMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/24 16:29
 */
public class case1008 {
    public static void main(String[] args) {

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs( preorder,0,preorder.length-1);
    }
    public TreeNode dfs( int[] nums,int l,int r){
        if(l>r){
            return null;
        }
        int ind = l+1;
        //miss ind==r
        while(ind<=r&&nums[ind]<nums[l]){
            ind++;
        }
        TreeNode root = new TreeNode(nums[l]);
        root.left =dfs(nums,l+1,ind-1);
        root.right =dfs(nums,ind,r);
        return root;
    }
}
