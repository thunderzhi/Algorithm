package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/13 11:13
 */
public class case1302 {

    public static void main(String[] args) {

    }
    int max_k,ans;//max_k==> currently find max deepth 当前找到的最大深度
    // , k=> current deepth node sum 当前最大深度处节点的和值;

    //k -> root 的深度
    public void getResult(TreeNode root ,int k ){
        if(root==null){
            return ;
        }
        if(k == max_k){
            ans += root.val;//找到同样深度的node，val相加
        }
        if(k>max_k){
            max_k = k;
            ans = root.val;//找到更深的node，val覆盖
        }
        getResult(root.left,k+1);
        getResult(root.right,k+1);
        return;
    }

    public int deepestLeavesSum(TreeNode root) {
        getResult(root,0);
        return ans;
    }
}
