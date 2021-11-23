package org.cxz.algorithm.off;


import org.cxz.algorithm.treepack.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/23 11:05
 */
public class caseO0409 {
    public static void main(String[] args) {
        List<List<Integer>> test = new caseO0409().test();
         System.out.println("lists = " + test);
    }
    public List<List<Integer>> test(){
        TreeNode r = new TreeNode(2);
        r.left = new TreeNode(1);
        r.right =new TreeNode(3);
        return BSTSequences(r);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            ans.add(new ArrayList<>());
            return ans;
        }
        List<List<Integer>> larr = BSTSequences(root.left);
        List<List<Integer>> rarr = BSTSequences(root.right);
        for(int i= 0;i<larr.size();i++){
            for (int j = 0; j < rarr.size(); j++) {
                LinkedList<Integer> buff = new LinkedList<>();
                buff.addLast(root.val);
                mergeSequence(larr.get(i),0,rarr.get(j),0,buff,ans);
            }
        }
        return ans;
    }
    public void mergeSequence(List<Integer> l,int lind,List<Integer> r,int rind,
                            LinkedList<Integer> buff,List<List<Integer>> ans){
        if(lind==l.size()&&rind==r.size()){
            ans.add(new LinkedList<>(buff));
            return;
        }
        if(lind<l.size()){
            buff.addLast(l.get(lind));
            mergeSequence(l,lind+1,r,rind,buff,ans);
            buff.removeLast();
        }
        if (rind<r.size()){
            buff.addLast(r.get(rind));
            mergeSequence(l,lind,r,rind+1,buff,ans);
            buff.removeLast();
        }
        return;
    }
}
