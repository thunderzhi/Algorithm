package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: todo not finish
 * @date 2021/12/22 10:33
 */
public class case255 {
    public static void main(String[] args) {

    }

    public boolean verifyPreorder(int[] preorder){
        // root--left--  right
        int left = 1;
        int right = left;
        int n = preorder.length;
        //find first bigger than root;
        while(right<n){
            if (preorder[right]<preorder[0]) {
                right++;
            }
        }
        return inorder(0,left,right,preorder);

    }

    public int pre = -1;
    public boolean inorder(int root,int left,int right,int[] arr){
        if (left>right){
            return true;
        }
        if(!inorder(left+1,left+2,right-1,arr)) {
            return false;
        }
        if(pre!=-1&&arr[pre]>=arr[root]){
            return false;
        }
        pre = root;

        if(!inorder(right+1,right+2,arr.length-1,arr)) {
            return false;
        }
        return true;
    }

}
