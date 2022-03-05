package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/5 22:01
 */
public class case637 {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<Double> ans = new ArrayList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            double sum =0;
            for(int i=0;i<n;i++){
                TreeNode t = queue.poll();
                sum += t.val;
                if(t.left!=null) queue.offer(t.left);
                if(t.right!=null) queue.offer(t.right);
            }
            ans.add((double)(sum/n));
        }
        return ans;
    }
}
