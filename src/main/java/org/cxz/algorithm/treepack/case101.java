package org.cxz.algorithm.treepack;

import org.cxz.DataStructures.tree.Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/20 10:30
 */
public class case101 {

    public boolean isSymmetric(TreeNode root) {

        if(root==null){
            return true;
        }
        if(root!=null&&root.left==null&&root.right==null){
            return true;
        }

        return _isSymmetric(root.left,root.right);
    }

    public boolean _isSymmetric(TreeNode a,TreeNode b){
        if(a==null&&b==null){
             return true;
        }
        if(a==null||b==null){
            return false;
        }
        if(a.val!=b.val){
            return false;
        }

        return _isSymmetric(a.right,b.left)&&_isSymmetric(a.left,b.right);

    }

}
