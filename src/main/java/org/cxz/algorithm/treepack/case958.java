package org.cxz.algorithm.treepack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/8 22:02
 */
public class case958 {
    public static void main(String[] args) {


    }


    ///BFS  BFS when u get first null,after that u get another not null node
    // it represents that its not a completeTree
    public boolean isCompleteTreeBFS(TreeNode root){
        if(root==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean reachnull = false;
        queue.offer(root);
        while(!queue.isEmpty()){

            TreeNode tmp = queue.poll();
            if (tmp==null){
                reachnull = true;
            }
            else {
                if(reachnull){
                    return false;
                }

                System.out.println("Poll "+tmp.val);
                TreeNode left = tmp.left;
                TreeNode right = tmp.right;
                queue.offer(left);
                queue.offer(right);
            }

        }
        return true;
    }

    public boolean isCompleteTreeRecursion(TreeNode root){
        //1 get the total node count of the tree
        // 2 use formula to validate
        // 3 recursive

        if(root==null){
            return true;
        }

        int total = getCount(root);
        int cnt =1;
        int m =1;
        while(cnt+2*m<=total){
            m*=2;
            cnt += m;
        }

        return judge(root,cnt,m);

    }


    public boolean judge(TreeNode root,int n ,int m){
        if(root== null) {
            return n==0;
        }
        if (n==0){
            return  false;
        }
        if(n==1) {
            return root.left==null &&root.right==null ;
        }

        int k =Math.max(0,2*m-1) ;
        int l = Math.min(m,n-k);
        int r = n-k-l;

        return judge(root.left,(k-1)/2+l,m/2)&&judge(root.right,(k-1)/2+r,m/2);

    }


    public int getCount(TreeNode root){
        if(root == null){
            return 0;
        }

        return getCount(root.left)+ getCount(root.right)+1;

    }
}
