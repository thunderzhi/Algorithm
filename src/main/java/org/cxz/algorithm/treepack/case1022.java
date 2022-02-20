package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/21 1:07
 */
public class case1022 {

    public int sumRootToLeaf(TreeNode root) {
        return getsum(root,0);
    }

    public int getsum(TreeNode root,int sum){
        if(root==null) return 0;
        //sum = sum*2+root.val;
        sum = (sum<<1)+root.val;// this is better
        if(root.left==null&&root.right==null) return sum;
        return getsum(root.left,sum)+getsum(root.right,sum);
    }
}
