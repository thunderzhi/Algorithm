package org.cxz.algorithm.off.I;

import org.cxz.algorithm.treepack.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/1 23:40
 */
public class caseOff068II {

    //ver 1   PATH
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList();
        List<TreeNode> listq = new ArrayList();
        getPath(root,p,listp);
        getPath(root,q,listq);
        TreeNode ans=null;
        for(int i=0;i<listp.size();i++){
            if(listp.get(i)==listq.get(i)){
                ans = listp.get(i);
                if(ans==p||ans==q) break;
                continue;
            }
            break;
        }
        return ans;
    }

    public boolean getPath(TreeNode root, TreeNode tar , List<TreeNode> track){
        if(root==null) return false;
        if(root.val == tar.val){
            track.add(root);
            return true;
        }
        track.add(root);
        if(getPath(root.left,tar,track)) return true;
        if(getPath(root.right,tar,track)) return true;
        track.remove(track.size()-1);
        return false;
    }

    //ver2
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return root;
        if(root.val==p.val||root.val==q.val) return root;
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l!=null&&r!=null) return root;
        if(l!=null&&r==null) return l;
        return r;
    }
}
