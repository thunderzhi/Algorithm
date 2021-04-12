package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/12 22:50
 */
public class case103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root ==null){
            return ans;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int length = queue.size();
            for(int i =0;i<length;i++){
                TreeNode n = queue.poll();
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
                arr.add(n.val);
            }
            ans.add(arr);
        }
        int size = ans.size();
        for(int i =0;i<size;i++){
            if(i%2==1){
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
}
