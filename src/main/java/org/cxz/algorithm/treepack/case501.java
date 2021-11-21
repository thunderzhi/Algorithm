package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/21 21:52
 */
public class case501 {
    public static void main(String[] args) {

    }
    public int cnt;
    public int max;
    public TreeNode cur;
    public List<Integer> ans;
    public HashMap<Integer,Integer> map;
    public int[] findMode(TreeNode root) {
        cnt =0;
        ans = new ArrayList<>();
        max = 0;
        cur = root;
        //map = new HashMap<>();
        inorder(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i]=ans.get(i);
        }
        return res;
    }

    public void inorder(TreeNode root){
        if (root==null){
            return;
        }
        inorder(root.left);
        if(cur.val == root.val){
            cnt+=1;
        }
        else  {
            cnt =1;
        }
        if(cnt>max){
            max = cnt;
            ans.clear();
            ans.add(root.val);
        }
        else if(cnt==max){
            ans.add(root.val);
        }
        cur = root;
        inorder(root.right);
        return;
    }

    public void preorder(TreeNode root){
        if (root==null){
            return;
        }
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        if(cnt<map.get(root.val)){
            System.out.println("cnt<root = " + root.val+" map.get(root.val)= "+map.get(root.val));
            cnt=map.get(root.val);
            ans.clear();
            ans.add(root.val);
        }
        else if(cnt==map.get(root.val)){
            ans.add(root.val);
        }
        preorder(root.left);
        preorder(root.right);
        return ;
    }
}
