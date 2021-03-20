package org.cxz.algorithm.stack;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        LinkedList<Integer> list = new LinkedList<>();
        while(!stack.isEmpty()){
            TreeNode peek = stack.peek();
            if(peek.left!=null){
                stack.push(peek.left);
                System.out.println("push left "+ peek.left.val);

                continue;
            }
            TreeNode tmp = stack.peek();
            System.out.println("pop "+ tmp);
            if (tmp.right!=null){

                stack.push(tmp.right);
                System.out.println("push right "+ tmp.right.val);
                continue;
            }
            else{
                TreeNode pop = stack.pop();
                list.add(pop.val);
            }

        }
        return list;
    }
}
