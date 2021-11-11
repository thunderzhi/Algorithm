package org.cxz.algorithm.bst;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: this is bst tree
 * @date 2021/11/11 11:05
 */
public class binary_search_tree {
    class Node{
        public int key;
        public Node left;
        public Node right;
        public Node(int val){
            this.key = val;
            this.left = null;
            this.right = null;
        }
    }

    // insert return the root of the val
    public Node insert(Node root,int val){
        if(root== null){
            return createNode(val);
        }
        if(root.key==val){
            return root;
        }
        else if(root.key<val){
            return root.right = insert(root.right,val);
        }
        else{
            return root.left = insert(root.left,val);
        }
    }

    // earse return the root of the delete node
    public Node earse(Node root ,int val){
        if(root==null){
            return root;
        }
        if(root.key<val){
            return root.right = earse(root.right,val);
        }
        else if(root.key>val){
            return root.left = earse(root.left,val);
        }
        else{
            //root key == val
            if(root.left==null&&root.right ==null){
                //degree == 0
                root = null;
                return root;
            }
            else if(root.left!=null||root.right !=null) {
                //degree == 1
                Node t = root.left==null?root.right:root.left;
                return t;
            }
            else {
                //degree == 2
                // find pre
                Node pre = findpre(root);
                root.key = pre.key;
                root.left = earse(root.left,pre.key);
            }
        }
        return root;
    }
    //get predeccessor node in inorder sequence of tree
    public Node findpre(Node root){
        // root and root.left couldn't be null
        Node p = root.left;
        while(p.right!=null){
            p = p.right;
        }
        return p;
    }

    public Node createNode(int val){
        return new Node(val);
    }

    public void clear(Node root){
        if(root==null){
            return;
        }
        clear(root.left);
        clear(root.right);
        root =null;
        return;
    }

}
