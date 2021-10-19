package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/19 22:13
 */
public class case114 {
    public static void main(String[] args) {

    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode[] arr = new TreeNode[2];
        arr[0]=null;
        arr[1]=null;
        createlist(root,arr);
    }

    public TreeNode createlist(TreeNode root,TreeNode[] arr){
        if(root==null){
            return null;
        }
        if(root.left==null&&root.right==null){
            arr[1]=root;//tail
            return root;
        }
        TreeNode l = root.left;
        TreeNode r = root.right;
        TreeNode[] larr = new TreeNode[2];
        TreeNode[] rarr = new TreeNode[2];
        if(l!=null){
            //找 left
            larr[0] =l;
            createlist(l,larr);

        }
        if(r!=null){
            rarr[0] = r;
            createlist(r,rarr);
        }

        if(l!=null&&r!=null){
            root.left =null;
            root.right = l;
            l.left = null;
            larr[1].right = r;
            r.left = null;
            arr[1] = rarr[1];
        }
        else if(l==null&&r!=null){
            root.left =null;
            root.right = r;
            r.left = null;
            arr[1] = rarr[1];
        }
        else{
            root.left = null;
            root.right = l;
            l.left =null;
            arr[1] =larr[1];

        }
        return null;
    }
}
