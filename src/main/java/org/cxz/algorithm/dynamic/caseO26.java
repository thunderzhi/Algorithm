package org.cxz.algorithm.dynamic;

import org.cxz.algorithm.treepack.TreeNode;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/17 14:46
 */
public class caseO26 {
    public boolean isMatch(TreeNode A, TreeNode B){
        if(A==null ){
            return false;
        }
        if( B==null){
            return false;
        }

        return A.val ==B.val&& isMatch(A.left,B.left)&&isMatch(A.left,B.left);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B){
        if(A==null ){
            return false;
        }
        if( B==null){
            return false;
        }
        if(A.val == B.val&&isMatch(A,B)){
            return true;
        }

        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
}
