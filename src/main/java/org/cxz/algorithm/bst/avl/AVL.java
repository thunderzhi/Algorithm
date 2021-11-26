package org.cxz.algorithm.bst.avl;



import static org.cxz.algorithm.bst.avl.Node.NIL;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/12 9:41
 */
public class AVL {
    public static final String[] TYPE = {"","LL","RR","LR","RL"};
    public enum Rotate_type{
        //={"","LL","RR","LR","RL"};
        LL("LL",1),
        RR("RR",2),
        LR("LR",3),
        RL("RL",4);
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getInd() {
            return ind;
        }

        public void setInd(int ind) {
            this.ind = ind;
        }

        private String name;
        private int ind;
        Rotate_type(String n ,int i){
            this.name = n;
            this.ind = i;
        }

    }
    public static void main(String[] args) {
        Node root = NIL;
        int[] arr = {5,9,8,3,2,4,1,7};
        AVL avl = new AVL();
        for (int i = 0; i < arr.length; i++) {
            System.out.println("=====tree print======");
            System.out.println("insert num = " + arr[i]);
            root = avl.insert(root,arr[i]);
            output(root);
            System.out.println("=====tree print done======");
        }

        System.out.println("finish");
    }
    public static void output(Node root){
        if(root == NIL){
            return;
        }
        print(root);
        output(root.left);
        output(root.right);
        return;
    }

    public static void print(Node root){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(root.key!=Integer.MIN_VALUE?root.key:"NIL");
        sb.append("[");
        sb.append(root.h);
        sb.append("] |");
        sb.append(root.left.key!=Integer.MIN_VALUE?root.left.key:"NIL");
        sb.append(" , ");
        sb.append(root.right.key!=Integer.MIN_VALUE?root.right.key:"NIL");
        sb.append(")");
        System.out.println(sb.toString());
    }

    public Node right_rotate(Node root){
        Node newroot = root.left;
        root.left = newroot.right;
        newroot.right = root;
        update_height(root);
        update_height(newroot);
        return newroot;
    }
    public Node left_rotate(Node root){
        Node newroot = root.right;
        root.right = newroot.left;
        newroot.left = root;
        update_height(root);
        update_height(newroot);
        return newroot;
    }


    private Node maintain(Node root) {
        if (Math.abs(root.left.h-root.right.h)<2) {
            return root;
        }
        int type = -1;
        int val = root.key;
        if(root.left.h>root.right.h){
            //L
            if(root.left.right.h>root.left.left.h){
                //LR
                System.out.println(root.left.key+ " : left_rotate ");
                root.left = left_rotate(root.left);
                type = 3;
            }
            System.out.println(root.key+ " : right_rotate ");
            root = right_rotate(root);
            if(type==-1){
                type = 1;
            }
        }
        else{
            //R   root.right.h>root.left.h
            if(root.right.left.h>root.right.right.h){
                //RL
                System.out.println(root.right.key+ " : right_rotate ");
                root.right = right_rotate(root.right);
                type = 4;
            }
            System.out.println(root.key+ " : left_rotate ");
            root = left_rotate(root);
            if(type==-1){
                type = 2;
            }
        }
        System.out.println(" maintain type = "+TYPE[type]);
        return root;
    }
    private void update_height(Node root) {
        root.h = Math.max(root.left.h,root.right.h)+1;
        return;
    }

    public Node getNewNode(int val){
        return new Node(val,1);
    }

    public Node insert(Node root,int val){
        if(root ==NIL){
            return getNewNode(val);
        }
        if(root.key == val){
            return root;
        }
        if(root.key>val){
            root.left = insert(root.left,val);
        }
        else{
            root.right = insert(root.right,val);
        }
        update_height(root);
        return maintain(root);
    }

    public Node prodecessor(Node root){
        Node p = root.left;
        while(p.right!=NIL){
            p = p.right;
        }
        return p;
    }


    public Node earse(Node root,int val){
        if(root== NIL){
            return root;
        }
        if(root.key > val){
            root.left = earse(root.left,val);
        }
        else if(root.key<val){
            root.right = earse(root.right,val);
        }
        else{
            if(root.left==NIL||root.right==NIL){
                //degree is 0 OR 1
                Node t = (root.left==NIL)?root.right:root.left;
                return t;
            }
            else{
                //degree is 2
                Node pre = prodecessor(root);
                root.key = pre.key;
                root.left = earse(root.left ,pre.key);
            }
        }
        update_height(root);
        return maintain(root);
    }

}
