package org.cxz.algorithm.treepack;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:  this package all info into a class,so it need more space than array
 * @date 2021/12/16 10:36
 */
public class case987 {
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


    public TreeMap<Integer,List<Node>> map ;//key --col,val --listnode

    public List<Node> list;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root,0,0);
        map = new TreeMap<>();
        for (Node node : list) {
             if(!map.containsKey(node.col)){
                List<Node> t = new ArrayList<>();
                map.put(node.col,t);
            }
            map.get(node.col).add(node);

        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer c :map.keySet()){
            List<Integer> t = new ArrayList<>();
            Collections.sort(map.get(c), new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if(o1.row==o2.row){
                            return o1.val - o2.val;
                        }
                    return o1.row - o2.row;
                }
            });
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
