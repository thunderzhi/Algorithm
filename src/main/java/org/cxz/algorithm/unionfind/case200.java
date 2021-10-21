package org.cxz.algorithm.unionfind;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/10/21 11:54
 */
public class case200 {
    public static void main(String[] args) {

    }
    public int n;
    public int[] fa;
    public int c;

    int ind(int i,int j){
        return (i*c+j);
    }
    int get(int x){
        return fa[x] =(fa[x]==x?x:get(fa[x]));
    }

    void merge(int a,int b){
        fa[get(a)]= get(b);
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        c =col;
        fa = new int[row*col+1];
        for (int i = 0; i < fa.length; i++) {
            fa[i]=i;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]=='0'){
                    continue;
                }
                if(i>0&&grid[i-1][j]=='1'){
                    merge(ind(i,j),ind(i-1,j));
                }
                if(j>0&&grid[i][j-1]=='1'){
                    merge(ind(i,j),ind(i,j-1));
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(fa[ind(i,j)]==ind(i,j)&&grid[i][j]=='1'){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}
