package org.cxz.algorithm.treepack;

import javax.lang.model.element.VariableElement;
import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/10 16:08
 */
public class case437 {
    public static void main(String[] args) {

    }
    public HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int pathSum(TreeNode root, int targetSum) {
        map.put(0,1);
        return count(root,0,targetSum);
    }

    private int count(TreeNode root, int sum, int targetSum) {
        if(root == null){
            return 0;
        }
        sum +=root.val;
        int ans = map.getOrDefault(sum-targetSum,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
        ans += count(root.left,sum,targetSum);
        ans += count(root.right,sum,targetSum);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return ans;
    }


}
