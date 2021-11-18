package org.cxz.algorithm.bst.rbt;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/18 13:44
 */
public class RBT {

    // create a new node
    public Node getNewNode(int key){
        return new Node(key);
    }

    /*
    Red black tree
    1 Node color is Red or black.
    2 The leaf node color should be black.
    3 The black node nums in Each path from root to leaf is same.[Contain NIL black node]
    4 If the node color is red,its parent and children have to be black.
    5 The color of NIL node is black
    All operation should obey these rules.
    */



}
