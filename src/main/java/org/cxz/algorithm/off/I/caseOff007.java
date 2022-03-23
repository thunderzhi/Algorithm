package org.cxz.algorithm.off.I;

import org.cxz.algorithm.treepack.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/16 15:59
 */
public class caseOff007 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root=null ;
        if(n==0) return root;
        if(n==1) return root = new TreeNode(preorder[0]);
        root = build(preorder,inorder,0,0,n-1);
        return root;
    }

    //ver 1 dfs
    public TreeNode build(int[] preorder,int[] inorder,
                          int rind,int l,int r){
        if(l>r) return null;
        if(l==r) return new TreeNode(inorder[l]);
        TreeNode root = new TreeNode(preorder[rind]);
        int mid = l;
        while(mid<=r&&inorder[mid]!=root.val) mid++;
        int lengthLeft = mid-l;
        int lengthRight = r-mid;
        if(lengthLeft>0){
            root.left = build(preorder,inorder,rind+1,l,mid-1);
        }
        if(lengthRight>0){
            root.right = build(preorder,inorder,rind+lengthLeft+1,mid+1,r);
        }
        return root;
    }

    //ver 2 ON
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = null;
        if(n==0) return root;
        root= new TreeNode(preorder[0]);
        if(n== 1) return root;
        Deque<TreeNode> st = new LinkedList();
        st.push(root);
        int ind =0;
        for(int i = 1;i<n;i++){
            int t = preorder[i];
            TreeNode node = new TreeNode(t);
            if(st.peek().val!=inorder[ind]){
                st.peek().left = node;
                st.push(node);
            }
            else{
                while(!st.isEmpty()&&st.peek().val==inorder[ind]){
                    node = st.pop();
                    ind++;
                }
                node.right = new TreeNode(t);
                st.push(node.right);
            }
        }
        return root;
    }


}
