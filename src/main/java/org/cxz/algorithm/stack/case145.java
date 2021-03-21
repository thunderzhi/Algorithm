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
        if(root==null){
            return res;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(root);
        s2.push(0);
        while (!s1.isEmpty()){
            int status = s2.peek();
            s2.pop();
            switch (status){
                case 0:{
                    s2.push(1);
                    if (s1.peek().left!=null){
                        s1.push(s1.peek().left);
                        s2.push(0);
                    }
                   }
                   break;
                case 1: {
                    s2.push(2);
                    if (s1.peek().right != null) {
                        s1.push(s1.peek().right);
                        s2.push(0);
                    }
                }
                break;
                case 2: {
                    res.add(s1.peek().val);
                    s1.pop();
                }
                break;
            }
        }
        return res;
    }


    public List<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
}
