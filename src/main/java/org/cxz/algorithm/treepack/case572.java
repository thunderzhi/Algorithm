package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/3 12:27
 */
public class case572 {

    //ver dfs
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null) return true;
        if(root==null||subRoot==null) return false;
        if(root.val==subRoot.val&&match(root,subRoot)){
            return true;
        }
        return isSubtree(root.right,subRoot)
                ||isSubtree(root.left,subRoot);
    }

    public boolean match(TreeNode root, TreeNode subRoot){
        if(root==null&&subRoot==null) return true;
        if(root==null||subRoot==null) return false;
        if(root.val!=subRoot.val) return false;
        return  match(root.right,subRoot.right)&& match(root.left,subRoot.left);
    }

    // kmp
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        List<Integer> rlist = new ArrayList<>();
        List<Integer> slist = new ArrayList<>();
        preorder(root,rlist);
        preorder(subRoot,slist);
        return kmp(rlist,slist);
    }

    public void preorder(TreeNode root, List<Integer> list){
        if(root==null){
            list.add(10001);
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    public void getNext(List<Integer> txt,int[] next){
        next[0]=-1;
        for (int i = 1,j=-1; i < txt.size(); i++) {
            while(j!=-1&&(txt.get(i).compareTo(txt.get(j+1))!=0)) j= next[j];
            if(txt.get(i).compareTo(txt.get(j+1))==0) j++;
            next[i] =j;
        }
    }

    public boolean kmp(List<Integer> txt,List<Integer> pattern){
        int[] next = new int[pattern.size()];
        getNext(pattern,next);
        for (int i = 0,j=-1; i < txt.size(); i++) {
            while(j!=-1&&(txt.get(i).compareTo(pattern.get(j+1))!=0)) j= next[j];
            if(txt.get(i).compareTo(pattern.get(j+1))==0) j++;
            if(j == pattern.size()-1) return true;
        }
        return false;
    }
}
