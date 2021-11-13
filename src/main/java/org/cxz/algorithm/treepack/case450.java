package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/13 10:59
 */
public class case450 {

    public static void main(String[] args) {

    }

    public TreeNode prodecessor(TreeNode root){
        TreeNode p = root.left;// miss left
        while(p.right!=null ){
            p = p.right;
        }
        return p;
    }
    public TreeNode deleteNode(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val>key){
            root.left = deleteNode(root.left,key);// add a return error
        }
        else{
            if(root.left==null||root.right==null){
                //d is 0 or 1
                TreeNode tmp = (root.left==null)?root.right:root.left;
                return tmp;
            }
            else{
                //d is 2
                TreeNode pre = prodecessor(root);
                root.val = pre.val;
                root.left= deleteNode(root.left,pre.val);
            }
        }
        return root;
    }
}
