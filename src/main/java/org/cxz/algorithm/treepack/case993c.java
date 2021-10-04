package org.cxz.algorithm.treepack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/4 22:50
 */
public class case993c {
    public static void main(String[] args) {

    }

    public class Data{
        int depth;
        TreeNode father;
        TreeNode node;
        Data(TreeNode n,TreeNode f,int d){
            depth =d;
            father =f ;
            node =n;
        }
    }
    //BFS
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        int dx =-1;
        int dy =-1;
        TreeNode xfather =null;
        TreeNode yfather =null;
        Queue<Data> queue = new LinkedList<Data>();
        Data data = new Data(root,null,0);
        queue.offer(data);

        while(!queue.isEmpty()){
            Data t = queue.peek();
            TreeNode cur = t.node;
            if(cur.val==x){
                dx = t.depth;
                xfather = t.father;
                // System.out.println("xfather "+xfather);
            }
            if(cur.val==y){
                dy = t.depth;
                yfather = t.father;
                // System.out.println("xfather "+xfather);
            }

            if(cur.left!=null){
                queue.offer(new Data(cur.left,cur,t.depth+1));
            }
            if(cur.right!=null){
                queue.offer(new Data(cur.right,cur,t.depth+1));
            }
            queue.poll();
        }
        return dx==dy && xfather!=yfather ;
    }

}
