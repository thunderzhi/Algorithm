package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/25 15:06
 */
public class case1448 {
    
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return goodNodes(root,max);
    }
    public int goodNodes(TreeNode root,int max){
        if(root==null) return 0;
        int res = root.val>=max?1:0;
        max = Math.max(root.val,max);
        res += goodNodes(root.left,max);
        res += goodNodes(root.right,max);
        return res;
    }
}
