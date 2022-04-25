package org.cxz.algorithm.dynamic;

import org.cxz.algorithm.treepack.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/23 17:33
 */
public class caseMIAN0412 {

    //ver 1 cap
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        int res = findsum(root,sum);
        return res+pathSum(root.left,sum)+pathSum(root.right,sum);
    }

    public int findsum(TreeNode root,int sum){
        if(root==null) return 0;
        int k = root.val;
        int l = findsum(root.left,sum-k);
        int r = findsum(root.right,sum-k);
        return l+r+((k==sum)?1:0);
    }

    //ver 2 ON ON
    public int pathSum2(TreeNode root, int sum) {
        if(root==null) return 0;
        Map<Long,Integer> map = new HashMap();
        map.put(0L,1);
        return preorder(root,0L,sum,map);
    }

    public int preorder(TreeNode root,long total,int sum,Map<Long,Integer> map){
        if(root==null) return 0;
        total += root.val;
        int ans = map.getOrDefault(total-sum,0);
        map.put(total,map.getOrDefault(total,0)+1);
        ans += preorder(root.left,total,sum,map);
        ans += preorder(root.right,total,sum,map);
        map.put(total,map.getOrDefault(total,0)-1);
        return ans;
    }
}
