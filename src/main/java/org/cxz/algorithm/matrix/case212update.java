package org.cxz.algorithm.matrix;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/9 16:00
 */
public class case212update {
    public class Tire{
        public class Node{
            public boolean isWord;
            public String val;
            public Map<Character, Node> children;
            public Node(){
                children = new HashMap<>();
                val="";
            }
        }
        public Node root;
        public Tire(){
            root = new Node();
        }

        public void add(String word){
            Node p = root;
            for(int i= 0;i<word.length();i++){
                char c = word.charAt(i);
//                int ind = word.charAt(i)-'a';
                if(p.children.get(c)==null){
                    p.children.put(c,new Node());
                }
                p = p.children.get(c);
            }
            p.isWord = true;
            p.val = word;
            return ;
        }

    }
    public int[][] dir;
    public int m,n;
    public boolean[][] mark;
    public List<String> findWords(char[][] board, String[] words) {
        Tire tire = new Tire();
        for(String s:words){
            tire.add(s);
        }
        dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        m = board.length;
        n = board[0].length;
        mark = new boolean[m][n];
        List<String> ans = new ArrayList();

        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                StringBuilder sb = new StringBuilder();
                dfs(i,j,sb,board,tire.root,ans);
            }
        }
        return ans;
    }

    public void dfs(int r,int c ,
                   StringBuilder sb,char[][] b,Tire.Node parent,List<String> ans){
        if(sb.length()>10||!parent.children.containsKey(b[r][c])){
            return;
        }

        char ch = b[r][c];
        Tire.Node cur = parent.children.get(ch);
        if(cur.isWord){
            ans.add(cur.val);
            cur.isWord =false;
            cur.val="";
        }
        sb.append(ch);
        mark[r][c] = true;
        if(!cur.children.isEmpty() ){
            for(int k=0;k<4;k++ ){
                int x = r + dir[k][0];
                int y = c + dir[k][1];
                if(x>=0&&x<m&&y>=0&&y<n&&!mark[x][y]){
                    dfs(x,y,sb,b,cur,ans);
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        mark[r][c] = false;
        if(cur.children.isEmpty()){
            parent.children.remove(ch);
        }
    }
}
