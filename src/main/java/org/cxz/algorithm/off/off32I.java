package org.cxz.algorithm.off;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/28 13:38
 */
public class off32I {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //6min
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            if(t.left!=null){
                queue.offer(t.left);
            }
            if(t.right!=null){
                queue.offer(t.right);
            }
            ans.add(t.val);
        }

        int[] res = new int[ans.size()];
        for(int i = 0;i<ans.size();i++){
            res[i] =ans.get(i);
        }
        return res;
    }
}
