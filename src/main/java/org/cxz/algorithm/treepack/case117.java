package org.cxz.algorithm.treepack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/19 13:50
 */
public class case117 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public static void main(String[] args) {

    }

    public Node connect(Node root) {
        Node p = root;
        while((p=layconnect(p))!=null){

        }
        return root;
    }
    public Node layconnect(Node root){
        Node newhead = null;
        Node pre = null;
        Node p = root;
        Node q = null;
        while(p!=null){
            if(p.left!=null){
                if(pre!=null){
                    pre.next = p.left;
                }
                pre = p.left;
            }
            if(newhead ==null){
                newhead = pre;
            }
            if(p.right!=null){
                if(pre!=null){
                    pre.next = p.right;
                }
                pre= p.right;
            }
            if(newhead==null){
                newhead = pre;
            }
            p = p.next;
        }
        return newhead;
    }

    public Node connect2(Node root) {
        Node p = root;
        while(p!=null){
            p = _connect(p);
        }
        return root;
    }
    public Node _connect(Node root){
        Node vh = new Node();
        Node tail = vh, p = root;
        while(p!=null){
            Node l = p.left, r =p.right;
            if(l!=null){
                tail.next = l;
                tail = tail.next;
            }
            if(r!=null){
                tail.next = r;
                tail = tail.next;
            }
            p = p.next;
        }
        return vh.next;
    }
}
