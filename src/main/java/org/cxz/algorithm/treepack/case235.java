package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 14:58
 */
public class case235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        int min = Math.min(p.val,q.val);
        int max = Math.max(p.val,q.val);
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();

        path1 = getpath(root,p,path1);
        path2 = getpath(root,q,path2);
        System.out.println(path1.size());
        System.out.println(path2.size());
        Stack<TreeNode> s = new Stack<>();
        TreeNode e = null;
        int length = Math.min(path1.size(),path2.size());
        for (int i = 0; i < length; i++) {
            if(path1.get(i).val==path2.get(i).val){
                s.push(path1.get(i));
            }
            else{
                e = s.peek();
                break;
            }

        }
        if(e==null){
            e = path1.get(length);
        }
        return e;

    }

    public List<TreeNode> getpath(TreeNode n,TreeNode t,List<TreeNode> ans){
        if(n.val==t.val){
            ans.add(n);
            return ans;
        }
        ans.add(n);
        if(n.val<t.val) {
           return getpath(n.right,t,ans);
        }
        if(n.val>t.val){
            return getpath(n.left,t,ans);

        }
        return ans;
    }
}
