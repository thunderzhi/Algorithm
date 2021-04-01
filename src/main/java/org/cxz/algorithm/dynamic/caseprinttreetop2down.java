package org.cxz.algorithm.dynamic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/1 13:48
 */
public class caseprinttreetop2down {
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> integers = new ArrayList<>();
            int length = queue.size();
            for (int i = 0; i < length ; i++) {
                TreeNode node = queue.poll();
                integers.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(integers);
        }
        return ans;
        if(roo == null){
            return ans;
        }
        if(ans.size)





    }
}
