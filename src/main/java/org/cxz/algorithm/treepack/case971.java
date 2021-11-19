package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/19 9:56
 */
public class case971 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r = new TreeNode(2);
        TreeNode l = new TreeNode(3);
        root.left = l ;
        root.right = r;
        int[] arr = {1,2,3};
        List<Integer> integers = new case971().flipMatchVoyage(root, arr);
        System.out.println(" = " + integers.toString());
    }
    public List<Integer> ans;
    public int ind;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ans = new ArrayList<>();
        ind =0;
        boolean res = preorder(root,voyage);
        if(!res){
            ans.clear();
            ans.add(-1);
        }
        return ans;
    }

    public boolean preorder(TreeNode root,int[] voyage){
        if(root==null ){//
            return true;// pre finish and voyage finish
        }

        int t = root.val;
        if(t!=voyage[ind]){
            return false;
        }
        System.out.println(" ind before + " + ind+" val ="+root.val);
        ind+=1;
        System.out.println(" ind after + " + ind);
        /*
        ind reach the end  ind==voyage.length ,ind+1 == voyage.length ,
        its different . ind+1==length is better
        */
        if(ind+1 ==voyage.length){

            System.out.println(" ind+1 = length " + ind);
            return true;// miss this
        }
        if(root.left!=null&&root.left.val!=voyage[ind]){
            //swap
            TreeNode tmp = root.left;
            root.left =root.right;
            root.right = tmp;
            ans.add(root.val);
        }
        if(!preorder(root.left,voyage)){
            return false;
        }

        if (!preorder(root.right,voyage)) {
            return false;
        }
        return true;
    }


}
