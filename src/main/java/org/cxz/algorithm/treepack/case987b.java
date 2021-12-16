package org.cxz.algorithm.treepack;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:  this can't support dup element
 * @date 2021/12/16 10:36
 */
public class case987b {
    public static void main(String[] args) {

    }

    public class Node{
        public int col;
        public int row;
        public int val;
        public Node(int c ,int r,int v){
            this.col= c;
            this.row = r;
            this.val = v;
        }
    }

    public TreeMap<Integer,TreeSet<Node>> map ;//key --col,val --listnode
    public List<Node> list;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root,0,0);
        map = new TreeMap<>();
        for (Node node : list) {
            if(!map.containsKey(node.col)){
                TreeSet<Node> t = new TreeSet<>(new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        if(o1.row==o2.row){
                            return o1.val - o2.val;
                        }
                        return o1.row - o2.row;
                    }
                });
                map.put(node.col,t);
            }
            map.get(node.col).add(node);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer c :map.keySet()){
            List<Integer> t = new ArrayList<>();
            for (Node node : map.get(c)) {
                t.add(node.val);
            }
            ans.add(t);
        }
        return ans;
    }

    public void dfs(TreeNode root,int row,int col){
        if(root==null){
            return;
        }
        list.add(new Node(col,row,root.val));
        //left
        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);

        return;
    }
}
