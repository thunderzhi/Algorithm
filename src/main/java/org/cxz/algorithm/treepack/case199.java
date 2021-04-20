package org.cxz.algorithm.treepack;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 9:06
 */
public class case199 {


    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        ArrayList<Stack<Integer>> ls = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int length = queue.size();
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < length; i++) {
                TreeNode tmp = queue.poll();
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
                st.push(tmp.val);
            }
            ls.add(st);
        }

        for (Stack<Integer> l : ls) {
            ans.add(l.pop());
        }
        return ans;
    }
}
