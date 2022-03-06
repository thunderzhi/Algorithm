package org.cxz.algorithm.treepack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/6 21:49
 */
public class case623 {

    //ver BFS
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1) {
            TreeNode t = new TreeNode(val);
            t.left =root;
            return t;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int cnt = 1;
        while(!queue.isEmpty()){
            cnt++;
            int n = queue.size();
            for(int i = 0;i<n;i++){
                TreeNode t = queue.poll();
                if(cnt==depth){
                    TreeNode l = new TreeNode(val);
                    TreeNode r = new TreeNode(val);
                    l.left = t.left;
                    t.left = l;
                    r.right = t.right;
                    t.right = r;
                }
                else{
                    if(t.left!=null) queue.offer(t.left);
                    if(t.right!=null) queue.offer(t.right);
                }
            }
            if(cnt==depth) break;
        }
        return root;
    }
}
