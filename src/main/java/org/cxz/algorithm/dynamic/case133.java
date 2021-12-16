package org.cxz.algorithm.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/12/16 9:31
 */
public class case133 {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Map<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node){
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newnode = new Node(node.val);
        map.put(node,newnode);
        for(Node n :node.neighbors){
            Node t = dfs(n);
            map.get(node).neighbors.add(t);
        }
        return newnode;
    }

}
