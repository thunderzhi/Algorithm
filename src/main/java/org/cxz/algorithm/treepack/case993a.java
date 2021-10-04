package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/4 22:50
 */
public class case993a {
    public static void main(String[] args) {

    }


    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        int xdepth = getdepth(root, x,0);
        int ydepth = getdepth(root, y,0);
        //System.out.println("xdepth "+xdepth);
        //System.out.println("ydepth "+ydepth);
        if(xdepth!=ydepth){
            return false;
        }
        TreeNode p = findxparent(root,x);
        //System.out.println("------");
        TreeNode q = findxparent(root,y);

        return !(p.val==q.val);
    }

    public TreeNode findxparent(TreeNode root, int x){
        if(root==null){
            return null;
        }

        TreeNode t=null;
        System.out.println("root 1 "+root.val);
        if(root.left!=null){
            if(root.left.val==x){
                //System.out.println("root left "+root.val);
                return root;
            }
            else{
                t = findxparent(root.left,x);

            }
        }
        if(t!=null){
            return t;
        }

        if(root.right!=null){
            if(root.right.val==x){
                //System.out.println("root right  "+root.val);
                return root;
            }
            else{
                t = findxparent(root.right,x);
            }
        }
        return t;

    }



    public int getdepth(TreeNode root, int x,int depth){
        if(root==null){
            return -1;
        }
        if(root.val==x){
            return depth;
        }
        depth +=1;
        int left = getdepth(root.left,x,depth);
        if(left>0){
            return left;
        }

        int right = getdepth(root.right,x,depth);
        if(right>0){
            return right;
        }
        return 0;
    }
}
