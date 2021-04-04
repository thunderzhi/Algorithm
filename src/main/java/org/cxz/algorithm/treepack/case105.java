package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/4 15:54
 */
public class case105 {

    public static void main(String[] args) {
        int[] a = new int[]{3,9,20,15,7};
        int[] b = new int[]{9,3,15,20,7};
        TreeNode treeNode = new case105().buildTree(a, b);


    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre= new ArrayList<>();
        List<Integer> in= new ArrayList<>();
        int i =0;
        while(i<preorder.length){
            pre.add(preorder[i]);
            i++;
        }
        i=0;
        while(i<inorder.length){
            in.add(inorder[i]);
            i++;
        }

        return _buildTree(pre,in);

    }

    public TreeNode _buildTree(List<Integer> preorder, List<Integer> inorder){
        if(preorder.size()==0){return null;}
        int pos =0 ;
        System.out.println("inorder "+inorder.size());
        while (inorder.get(pos).equals(preorder.get(0))  ) {
            System.out.println(pos);
            pos++;
        }
        List<Integer> lpre = new ArrayList<>();
        List<Integer> lin = new ArrayList<>();
        List<Integer> rpre = new ArrayList<>();
        List<Integer> rin = new ArrayList<>();
        for(int i = 0;i<pos ;i++){
            lpre.add(preorder.get(i+1));
            lin.add(inorder.get(i));
        }
        for(int i = pos+1;i<inorder.size();i++){
            rpre.add(preorder.get(i));
            rin.add(inorder.get(i));
        }
        TreeNode root = new TreeNode(preorder.get(0)) ;
        root.left = _buildTree(lpre,lin);
        root.right = _buildTree(rpre,rin);
        return root;
    }
}
