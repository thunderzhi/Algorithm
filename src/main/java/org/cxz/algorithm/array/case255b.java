package org.cxz.algorithm.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: todo not finish
 * @date 2021/12/22 10:33
 */
public class case255b {
    public static void main(String[] args) {

    }

    public boolean verifyPreorder(int[] preorder){
        Deque<Integer> stack = new LinkedList<>();
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            while(!stack.isEmpty()&&stack.peekLast()<preorder[i]){
                pre = stack.pollLast();
            }
            if (preorder[i]<pre){
                return false;
            }
            stack.offerLast(preorder[i]);
        }
        return true;

    }

    public int preind =-1;
    public boolean inorder(int[] arr,int l,int r){
        if (r-l<1){
            return true;
        }
        int ind = l+1;
        while(ind<r&&arr[ind]<arr[l]){
            ind+=1;
        }
        if(!inorder(arr,l+1,ind)) {
            return false;
        }
        if(preind!=-1&&arr[l]<arr[preind]){
            return false;
        }
        preind = l;
        if(!inorder(arr,ind,r)) {
            return false;
        }
        return true;
    }

}
