package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/29 14:09
 */
public class case979 {

    public static void main(String[] args) {


    }

    int ans;
    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    /*
    * 定义一个dfs(node)，返回值代表以node 为根的子树，需要移入或者移出多少个coin

dsf(node) == cnt >0 代表要移出cnt个coin，
Cnt<0 代表移入cnt个coin，==0代表不用移动。
如果node是叶子节点，那么计算的方法就是node.val-1,
如果node是非叶子节点，那么就需要node.val+dfs(L)+dfs(R)-1
在dfs过程中，将左右子树的dfs返回值|L|+|R|,就是最少的移动次数

*/
    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }



}
