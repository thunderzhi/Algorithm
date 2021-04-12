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
 * @date 2021/4/12 22:43
 */
public class case107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root ==null){
            return ans;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> arr = new ArrayList<>();
            int length = queue.size();
            for(int i=0;i<length;i++){
                TreeNode tmp = queue.poll();
                arr.add(tmp.val);
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }
            ans.add(arr);
        }
        Collections.reverse(ans);
//        for(int i=0,j=ans.size()-1;i<j;i++,j--){
//            List<Integer> tmp = ans.get(i);
//            ans.set(i,ans.get(j));
//            ans.set(j,tmp);
//
//        }
        return ans;
    }
}
