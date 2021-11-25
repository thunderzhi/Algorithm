package org.cxz.algorithm.bst.rbt;

import static org.cxz.algorithm.bst.rbt.Node.NIL;
/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 *  Red black tree
 *     1 Node color is Red or black.
 *     2 The leaf node color should be black.
 *     3 The black node nums in Each path from root to leaf is same.[Contain NIL black node]
 *     4 If the node color is red,its parent and children have to be black.
 *     5 The color of NIL node is black
 *     All operation should obey these rules.
 *
 * @date 2021/11/18 13:44
 */
public class RBT {

    public static void main(String[] args) {
        NodeColorEnum black = NodeColorEnum.BLACK;

        System.out.println("black = " + NodeColorEnum.BLACK.ordinal() );
    }
    // create a new node
    public Node getNewNode(int key){
        return new Node(key);
    }

    //insert a node to root ,return the root node of the tree
    public Node insert(Node root, int key){
        // insert op ,return the root after insert a new node and some adjust
        root = _insert(root,key);
        // color the root as 1==black
        root.color = NodeColorEnum.BLACK;
        return root;
    }


    public Node _insert(Node root, int key){
        if(root==NIL){
            return getNewNode(key);// miss this
        }
        if (root.key == key){
            return root;
        }
        if(root.key<key){
            // new node should insert in right
            root.right = _insert(root.right,key);
        }
        else{
            // new node should insert in left
            root.left = _insert(root.left,key);
        }
        return insert_maintain(root); // this func return the root after adjust
        //return root;
    }


    //maintain RB Rule
    public Node insert_maintain(Node root){
        int flag =0;
        /*
        miss a very important check
        flag >0 ,it means that some conficts
        if left is red ,and left has red child flag =1
        if red is red ,and red has red child flag =2
         */
        if(root.left.color== NodeColorEnum.RED&&has_redchild(root.left)){
            flag =1;
        }
        if(root.right.color== NodeColorEnum.RED&&has_redchild(root.right)){
            flag =2;
        }
        if(flag == 0){
            return root;// no conflict return
        }

        /*
        scence 1 father and uncle are red
        color the grandfather to red,color uncle and father node to red.
        return;
        */
        //
        if(root.left.color==NodeColorEnum.RED&&root.right.color==NodeColorEnum.RED){
           // through the flag check must have a red child
            root.color = NodeColorEnum.RED;
            root.left.color= NodeColorEnum.BLACK;
            root.right.color= NodeColorEnum.BLACK;
            return root;//scence 1 finish
        }

        /*
        both red child node processed ,now only one child have red
        scence 2 uncle is black , father and children are red
        */
        if(flag ==1 ){
            //left is red
            if(root.left.right.color==NodeColorEnum.RED ){
                //LR need  left_rotate
                root.left = left_rotate(root.left);
            }
            //right_rotate
            root = right_rotate(root);
        }
        else{
            //right is red
            if(root.right.left.color == NodeColorEnum.RED){
                //RL need right_rotate
                root.right = right_rotate(root.right);
            }
            //left_rotate
            root = left_rotate(root);
        }

        // now process root and its two child.we choice red up
        root.color = NodeColorEnum.RED;
        root.right.color = NodeColorEnum.BLACK;
        root.left.color = NodeColorEnum.BLACK;
        return root;
    }

    //return root after del the node val equals to key
    public Node erase(Node root,int key){
        root = _erase(root,key);
        root.color = NodeColorEnum.BLACK;
        return root;
    }



    // real erase operation
    public Node _erase(Node root,int key){
        if(root==NIL){
            return root;
        }
        if(root.key>key){
            //go left erase
            root.left = _erase(root.left,key);
        }
        else if(root.key <key){
            //go right erase
            root.right = _erase(root.right,key);
        }
        else{
            // root val === key,ready erase
            if (root.right==NIL||root.left==NIL){
                // degree is 0 or 1
                Node t = root.right==NIL?root.left:root.right;
                // miss color
                t.color =NodeColorEnum.getEnum(t.color.ordinal()+root.color.ordinal());
                return t;
            }
            else{
                // degree is 2
                Node tmp = predecessor(root);
                root.key = tmp.key;
                root.left =_erase(root.left,tmp.key);
            }
        }

        //erase maintain
        return eraseMaintain(root);
    }

    //
    public Node eraseMaintain(Node root){
        if(root.left.color!= NodeColorEnum.DOUBLE_BLACK&&
                root.right.color!= NodeColorEnum.DOUBLE_BLACK){
            // both child not double black
            return root;
        }
        // at least one child is dblack
        int flag= 0;
        if(has_redchild(root)){
            root.color = NodeColorEnum.RED;
            // it means dblack node has a red brother
            if (root.left.color==NodeColorEnum.RED){
                //dblack node is right ,red brother on left,right_rotate
                root = right_rotate(root);
                flag =1;
            }
            else{
                //dblack node is left ,red brother on right ,need leftrotate
                root = left_rotate(root);
                flag =2;
            }
            root.color = NodeColorEnum.BLACK;
            if(flag==1){
                root.right = eraseMaintain(root.right);
            }
            else{
                root.left = eraseMaintain(root.left);
            }
            return root;
        }

        // dblack's brother is black

        if((root.left.color==NodeColorEnum.DOUBLE_BLACK&&!has_redchild(root.right))||
                (root.right.color==NodeColorEnum.DOUBLE_BLACK&&!has_redchild(root.left)))
        {
            // brother is common black ,and no any red child
            root.right.color = NodeColorEnum.getEnum(root.right.color.ordinal()+1);
            root.left.color = NodeColorEnum.getEnum(root.left.color.ordinal()+1);
            root.color = NodeColorEnum.getEnum(root.color.ordinal()+1);
            return root;
        }

        // brother is common black and have at least one red child
        if (root.right.color==NodeColorEnum.BLACK){
            //dblack is left
            root.left.color =NodeColorEnum.BLACK;//dblack color black
            if(root.right.right.color!=NodeColorEnum.RED){
                root.right.color = NodeColorEnum.RED;
                //RL
                root.right =right_rotate(root.right);
                root.right.color = NodeColorEnum.BLACK;
            }
            //RR
            root.right.color = root.color;//new root should color old root color
            root = left_rotate(root);
        }
        else{
            //dblack is right root.left is black
            root.right.color =NodeColorEnum.BLACK;//dblack color black
            if(root.left.left.color!=NodeColorEnum.RED){
                root.left.color = NodeColorEnum.RED;
                //LR
                root.left =left_rotate(root.left);
                root.left.color = NodeColorEnum.BLACK;
            }
            //LL
            root.left.color = root.color;//new root should color old root color
            root = right_rotate(root);
        }
        root.right.color = NodeColorEnum.BLACK;
        root.left.color = NodeColorEnum.BLACK;
        return root;
    }

    //region common method
    //left_rotate
    public Node left_rotate(Node root){
        Node newroot = root.right;
        root.right = newroot.left;
        newroot.left = root;
        return root;
    }

    //right_rotate
    public Node right_rotate(Node root){
        Node newroot = root.left;
        root.left = newroot.right;
        newroot.right = root;
        return newroot;
    }

    // if the node have a child node color is red ,return true
    public boolean has_redchild(Node root){
        return root.left.color==NodeColorEnum.RED||root.right.color==NodeColorEnum.RED;
    }

    //find node predecessor
    public Node predecessor(Node root){
        Node p = root.left;
        while(p.right!=NIL){
            p = p.right;
        }
        return p;
    }


    //endregion
}
