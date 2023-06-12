package org.cxz.contest.test2023102dweek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/15 22:27
 */
public class test0415d {
     public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    long[] sum;
    Map<TreeNode,Integer> map;
    public TreeNode replaceValueInTree(TreeNode root) {
        map = new HashMap<>();
        int deep = dfs(root);//get deep
        sum = new long[deep];
        System.out.println("sum = " + Arrays.toString(sum));

        calc(root,root.val); // calc sum;
        map.put(root,null);
        update(root,0);
        return root;
    }
    void update(TreeNode root,int d){
        if(root==null) return;
        Integer t = map.get (root);
        System.out.println("d = " + d+" nval: "+root.val+ " t: "+t+" sum: "+sum[d]);
        root.val = (int)(sum[d]-t);
        update(root.left,d+1);
        update(root.right,d+1);
        return;
    }
    void calc(TreeNode root,int d){
        if(root==null) return;
        sum[d] += root.val;
        if(root.left!=null){
            calc(root.left,d+1);
        }
        if(root.right!=null){
            calc(root.right,d+1);
        }
        int t=0;
        t+= root.left!=null?root.left.val:0;
        t+= root.right!=null?root.right.val:0;
        map.put(root.left,t);
        map.put(root.right,t);
        return;
    }
    int dfs(TreeNode root){
        if(root==null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        return Math.max(l,r)+1;
    }

}
