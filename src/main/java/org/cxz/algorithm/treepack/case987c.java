package org.cxz.algorithm.treepack;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: use array save col,row and val,
 * @date 2021/12/16 10:36
 */
public class case987c {
    public static void main(String[] args) {

    }

    public TreeMap<Integer,List<int[]>> map ;//key --col,val --listnode
    public List<int[]> list;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        list = new ArrayList<>();
        dfs(root,0,0);
        map = new TreeMap<>();
        for (int[] node : list) {

            if(!map.containsKey(node[0])){
                List<int[]> t = new ArrayList<>();

                map.put(node[0],t);
            }
            map.get(node[0]).add(node);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer c :map.keySet()){
            List<Integer> t = new ArrayList<>();
            Collections.sort(map.get(c), new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[1]==o2[1]){
                            return o1[2] - o2[2];
                        }
                    return o1[1]-o2[1];
                }
            });
            for (int[] node : map.get(c)) {
                t.add(node[2]);
            }
            ans.add(t);
        }
        return ans;
    }

    public void dfs(TreeNode root,int row,int col){
        if(root==null){
            return;
        }
        list.add(new int[]{col,row,root.val});

        //left
        dfs(root.left,row+1,col-1);
        dfs(root.right,row+1,col+1);

        return;
    }
}
