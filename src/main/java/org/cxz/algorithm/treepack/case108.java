package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/13 16:13
 */
public class case108 {
    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return build(nums,0,nums.length-1);
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
}
