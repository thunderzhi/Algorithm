package org.cxz.algorithm.treepack;

import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/20 14:12
 */
public class case1367 {
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head==null){
            return true;
        }
        if (root == null){
            return false;
        }
        if (head.val==root.val&&judge(root,head)){
            return true;
        }
        return isSubPath(head,root.left)||isSubPath(head,root.right);
    }

    public boolean judge(TreeNode root,ListNode head){
        if (head == null){
            return true;
        }
        if (root == null){
            return false;
        }
        if (head.val!=root.val){
            return false;
        }
        return judge(root.left,head.next)||judge(root.right,head.next);
    }

}
