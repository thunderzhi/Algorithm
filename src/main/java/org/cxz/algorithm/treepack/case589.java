package org.cxz.algorithm.treepack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/4/12 19:17
 */
public class case589{
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public static void main(String[] args) {

    }
//    void _preorder(Node root,List<Integer> ans){
//        if(root == null){
//            return;
//        }
//        ans.add(root.val);
//        for (int i = 0; i <root.children.size() ; i++) {
//            _preorder(root.children.get(i),ans);
//        }
//        return;
//    }
//
//    public List<Integer> preorder(Node root) {
//        List<Integer> ans = new ArrayList<>();
//        _preorder(root,ans);
//        return ans;
//    }

    //iteratively
public List<Integer> preorder(Node root) {
    if(root == null){
        return new ArrayList<Integer>();
    }
    List<Integer> ans = new ArrayList<Integer>();
    Stack<Node> st = new Stack<Node>();
    st.push(root);
    while(!st.isEmpty()){
        Node tmp = st.peek();
        st.pop();
        ans.add(tmp.val);
        if(tmp.children!=null&&tmp.children.size()>0 ){
            int childlength = tmp.children.size();
            List<Node> _children = tmp.children;
            for(int i = childlength -1;i>=0;i--){
                st.push(_children.get(i));
            }
        }
    }
    return ans;
}
}
