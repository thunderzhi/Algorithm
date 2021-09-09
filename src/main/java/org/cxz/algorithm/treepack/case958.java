package org.cxz.algorithm.treepack;

import java.util.LinkedList;
import java.util.Queue;

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

    ///BFS  BFS when u get first null,after that u get another not null node
    // it represents that its not a completeTree
    public boolean isCompleteTreeBFS(TreeNode root){
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean reachnull = false;
        queue.offer(root);
        while(!queue.isEmpty()){

            TreeNode tmp = queue.poll();
            if (tmp==null){
                reachnull = true;
            }
            else {
                if(reachnull){
                    return false;
                }

                System.out.println("Poll "+tmp.val);
                TreeNode left = tmp.left;
                TreeNode right = tmp.right;
                queue.offer(left);
                queue.offer(right);
            }

        }
        return true;
    }

    public boolean isCompleteTreeRecursion(TreeNode root){
        //1 get the total node count of the tree
        // 2 use formula to validate
        // 3 recursive





    }



}
