package org.cxz.algorithm.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/9 16:00
 */
public class case212 {
    public class Tire{
        public class Node{
            public boolean isWord;
            public String val;
            public Node[] next;
            public Node(){
                next = new Node[26];
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
                int ind = word.charAt(i)-'a';
                if(p.next[ind]==null){
                    p.next[ind] = new Node();
                }
                p = p.next[ind];
            }
            p.isWord = true;
            p.val = word;
            return ;
        }

        public Boolean get(String word){
            Node p = root;
            for(int i= 0;i<word.length();i++){
                int ind = word.charAt(i)-'a';
                if(p.next[ind]==null){
                    return false;
                }
                p = p.next[ind];
            }
            if(p.isWord) return true;
            return false;
        }
    }
    public int[][] dir;
    public int m,n;
    public Set<String> set;
    public boolean[][] mark;
    public List<String> findWords(char[][] board, String[] words) {
        Tire tire = new Tire();
        for(String s:words){
            //System.out.println("get1: "+ tire.get(s));
            tire.add(s);
            //System.out.println("get2: "+ tire.get(s));
        }
        dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        m = board.length;
        n = board[0].length;
        mark = new boolean[m][n];
        List<String> ans = new ArrayList();
        set = new HashSet();
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                StringBuilder sb = new StringBuilder();
                dfs(i,j,sb,board,tire,ans);
            }
        }
        return ans;
    }
    // 超时 2022 1219测试 test case 64
    public void dfs(int r,int c ,
                    StringBuilder sb,char[][] b,Tire tire,List<String> ans){
        if(sb.length()>10){
            return;
        }
        sb.append(b[r][c]);
        String str = sb.toString();
        //System.out.println("str: "+ str);
        if(!set.contains(str)&&tire.get(str)){
            //System.out.println("add: "+ tire.get(str));
            set.add(str);
            ans.add(str);
        }
        mark[r][c] = true;
        for(int k=0;k<4;k++ ){
            int x = r + dir[k][0];
            int y = c + dir[k][1];
            if(x>=0&&x<m&&y>=0&&y<n&&!mark[x][y]){
                dfs(x,y,sb,b,tire,ans);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        mark[r][c] = false;
        return;
    }


}
