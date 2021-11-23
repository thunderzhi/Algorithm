package org.cxz.algorithm.off;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/23 16:57
 */
public class caseO33 {
    public static void main(String[] args) {



    }

    public int pre;
    public boolean verifyPostorder(int[] postorder) {
        pre =-1;
        return inorder(postorder,0,postorder.length-1);
    }
    public boolean inorder(int[] num,int l,int r){
        if(l>r){
            return true;
        }
        //root is r
        int ind = l;
        while(num[ind]<num[r]){
            ind++;
        }
        if(!inorder(num,l,ind-1)){
            return false;
        }
        if(pre!=-1&&num[pre]>=num[r]){
            return false;
        }
        pre =r;
        if(!inorder(num,ind,r-1)){
            return false;
        }
        return true;
    }
}
