package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/30 10:43
 */
public class case863 {
    public static void main(String[] args) {

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        int[] karr ={k};
        getRes(root,target,karr,ans);
        return ans;
    }




    //find target in root,return target when u get it.
    public TreeNode getRes(TreeNode root, TreeNode target, int[] k,List<Integer> ans ){

        if(root==null){
            return root;
        }

        System.out.println("B root = " + root.val + " k = "+k[0]);
        if(root.val==target.val){
            findk(root,0,k[0],ans);
            System.out.println("1 root = " + root.val + " k = "+k[0]);
            return root;
        }
        if(getRes(root.left,target,k,ans)!=null){
            System.out.println("2 root = " + root.val + " k = "+k[0]);
            k[0]-=1;
            if(k[0]==0){
                ans.add(root.val);
                return target;
            }
            findk(root.right,0,k[0]-1,ans);
            return target;
        }
        else if(getRes(root.right,target,k,ans)!=null){
            System.out.println("3 root = " + root.val + " k = "+k[0]);
            k[0]-=1;
            if(k[0]==0){
                ans.add(root.val);
                return target;
            }
            findk(root.left,0,k[0]-1,ans);
            return target;
        }
        return null;
    }

    public void findk(TreeNode root,int d,int k,List<Integer> arr){
        if(k<0){
            return;
        }
        if(root==null){
            return ;
        }
        if(k==d){
            arr.add(root.val);
            return;
        }
        findk(root.left,d+1,k,arr);
        findk(root.right,d+1,k,arr);
        return;
    }

}
