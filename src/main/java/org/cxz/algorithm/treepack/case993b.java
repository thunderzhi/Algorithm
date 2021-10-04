package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/4 22:50
 */
public class case993b {
    public static void main(String[] args) {

    }
    //DFS
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        TreeNode[] xparent =new TreeNode[1];
        TreeNode[] yparent =new TreeNode[1];
        int xdepth = getdepth(root, x,xparent);
//System.out.println("xparent "+xparent);
        int ydepth = getdepth(root, y,yparent);
        //  System.out.println("yparent "+yparent);
        return xdepth==ydepth&& xparent[0]!=yparent[0] ;

    }


    public int getdepth(TreeNode root, int x,TreeNode[] parent){
        if(root==null){
            return -1;
        }
        if(root.val==x){
            return 0;
        }
        parent[0] =root;
        int res=0;

        //  System.out.println("parent "+parent);
        res = getdepth(root.left,x,parent);
        if(res!=-1){
            return res+1;
        }
        parent[0] =root;
        res = getdepth(root.right,x,parent);
        if(res!=-1){
            return res+1;
        }
        return -1;
    }


}
