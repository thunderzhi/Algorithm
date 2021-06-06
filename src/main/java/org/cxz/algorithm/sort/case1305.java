package org.cxz.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/6/6 22:53
 */
public class case1305 {

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
    public static void main(String[] args) {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        getNums(root1,a1);
        getNums(root2,a2);
        List<Integer> ans = new ArrayList<>();
        int p =0,q=0;
        while(p<a1.size()||q<a2.size()){
            if((q>a2.size())||(p<a1.size()&&a1.get(p)<=a2.get(q))){
                ans.add(a1.get(p));
                p++;
            }
            else{
                ans.add(a2.get(q));
                q++;
            }
        }
        return  ans;
    }

    public void getNums(TreeNode t ,List<Integer> a){
        if(t==null){
            return;
        }
        getNums(t.left,a);
        a.add(t.val);
        getNums(t.right,a);
        return;
    }


}
