package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/13 16:14
 */
public class case98 {
    public static void main(String[] args) {

    }

    //todo this method need more param
    public boolean isValidBST2(TreeNode root) {

        TreeNode  l = root.left;
        TreeNode r = root.right;
        if(l==null&&r==null){
            return true;
        }
        if(l!=null&&l.val>=root.val){
            return false;
        }
        if(r!=null&&r.val<=root.val){
            return false;
        }
        if(l!=null&&r!=null){
            return isValidBST(l)&&isValidBST(r);
        }
        else{

            return  l==null?isValidBST(r):isValidBST(l);
        }

    }

    public void inorder(TreeNode root){
        if(root ==null){
            return ;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
        return;
    }
    public List<Integer> list;
    //pass
    public boolean isValidBST(TreeNode root) {

        list = new ArrayList<>();
        inorder(root);
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
    public void inorderr(TreeNode root){
        if(root==null){
            return ;
        }
         inorderr(root.left);
        if(pre!=null&&pre.val>=root.val){
            flag = false;
        }
        pre = root;
        inorderr(root.right);
        return;
    }
    public boolean flag ;
    public TreeNode pre;
    //this method pass
    public boolean isValidBST3(TreeNode root) {
        pre = null;
        flag = true;
        inorderr(root);
        return flag;
    }

    public boolean capinorder(TreeNode root){
        if(root==null){
            return true ;
        }
        if(!capinorder(root.left)){
            return false;
        }
        if(pre!=null&&pre.val>=root.val){
            return false;
        }
        pre = root;
        if(!capinorder(root.right)){
            return false;
        }
        return true;
    }

    public boolean isValidBST4(TreeNode root) {
        pre = null;
        return capinorder(root);
    }


}
