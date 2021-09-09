package org.cxz.algorithm.dynamic;


/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/9/9 14:04
 */
public class caseO036 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    public static void main(String[] args) {


    }

    Node head;
    Node pre;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        head =null;// head point to the first ele
        pre = null;//pre point to the last ele
        inorder(root);

        //link first and last  return
        pre.right= head;
        head.left = pre;
        return head;
    }

    public void inorder(Node root){
        if(root ==null){
            return;
        }
        inorder(root.left);
        //root
        if(pre==null){
            head = root;
        }
        else{
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        inorder(root.right);
        return;
    }
}
