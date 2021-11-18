package org.cxz.algorithm.bst.rbt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: Red Black Tree Node
 * @date 2021/11/18 11:23
 */
public class Node {
    public static final Node NIL = new Node(Integer.MIN_VALUE,0);
    //public static Node Nil ;
    public int key;
    public int color;// 0 red 1 black 2 double black
    public Node left;
    public Node right;
    public Node(int val,int _color){
        this.key = val;
        this.color = _color;
        this.left = NIL;
        this.right = NIL;
    }
}
