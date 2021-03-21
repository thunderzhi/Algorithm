package org.cxz.algorithm.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/3/18 11:44
 */
public class case145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = new case145().postorderTraversal(root);
        System.out.println(list.toString());
    }

    //recur
    public void postorder(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
}
