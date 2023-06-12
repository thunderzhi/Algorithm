package org.cxz.contest.test2023343week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/30 1:12
 */
public class test0430b {
    int m,n;
    public int getidx(int x,int y){
        return x*n+y;
    }
    public int[] getCor(int x){
        return new int[]{x/n,x%n};
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];
        int[] g = new int[m*n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[mat[i][j]] = getidx(i,j);
            }
        }
        System.out.println("m = " + m +" n "+n);
        int ans =0;
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            int[] cor = getCor(g[v]);
            int x = cor[0],y = cor[1];
            System.out.println("i = " + i + " x: "+x +" y: "+y+ " v "+v+" gv "+g[v]);
            ++rows[x];
            ++cols[y];
            System.out.println("rows["+x+"]= " + rows[x]);
            System.out.println("cols["+y+"]= " + cols[y]);

            if(rows[x]==n||cols[y]==m){
                ans = i;
                break;
            }
        }
        return ans;
    }
}
