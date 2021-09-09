package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/8 22:02
 */
public class case958 {
    public static void main(String[] args) {


    }


    public int getCount(TreeNode node){
        if(node==null){
            return  0;
        }

        return getChildNodecount(node);

    }

    public int getChildNodecount(TreeNode node){
        if (node==null){
            return 0;
        }

        int left = getChildNodecount(node.left);
        int right = getChildNodecount(node.right);
        return left+right+1;

    }
}
