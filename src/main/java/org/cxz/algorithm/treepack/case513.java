package org.cxz.algorithm.treepack;


import jdk.nashorn.internal.ir.ReturnNode;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/31 17:23
 */
public class case513 {
    public static void main(String[] args) {

    }
    int max_k;
    int val;
    public int findBottomLeftValue(TreeNode root) {
        max_k =-1;
        val= 0;
        dfs(root,0);
        return val;
    }
    public void dfs(TreeNode root , int dep){
        if(root==null){
            return;
        }
        if(dep>max_k){
            max_k = dep;
            val = root.val;
        }
        dfs(root.left,dep+1);
        dfs(root.right,dep+1);
        return;
    }
}
