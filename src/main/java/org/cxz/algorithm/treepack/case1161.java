package org.cxz.algorithm.treepack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/1 11:08
 */
public class case1161 {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        int sum = Integer.MIN_VALUE;
        int dep = 0;
        int ans = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            dep++;
            int tmp = 0;
            for(int i = 0;i<len;i++){
                TreeNode cur = queue.poll();
                tmp += cur.val;
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
            if(sum<tmp){
                ans = dep;
                sum = tmp;
            }
        }
        return ans;
    }
}
