package org.cxz.algorithm.bst.avl;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/12 16:18
 */
public class Node {
    public static final Node  NIL = new Node(Integer.MIN_VALUE,0);
    //public static Node Nil ;
    public int key;
    public int h;
    public Node left;
    public Node right;
    public Node(int val,int high){
        this.key = val;
        this.h = high;
        this.left = NIL;
        this.right = NIL;
    }
}
