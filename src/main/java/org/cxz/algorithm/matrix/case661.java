package org.cxz.algorithm.matrix;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/9 11:28
 */
public class case661 {
    public int m ,n;
    public int[][] sum;
    //ver1 
    public int[][] imageSmoother(int[][] img) {
        m = img.length;
        n = img[0].length;
        sum = new int[m+1][n+1];
        init(img);
        int[][] ans = new int[m][n];
        for(int i= 0;i<m;i++){
            for(int j =0;j<n;j++){
                // sum[i][j] = sum[i-1][j]+img[i-1][j-1];
                ans[i][j] = getsum(i,j);
            }
        }
        return ans;
    }
    public void init(int[][] img){
        for(int i= 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+img[i-1][j-1];
            }
        }
        return ;
    }

    public int getsum(int x,int y){
        int cnt = (Math.min(m-1,x+1)-Math.max(0,x-1)+1)
                *(Math.min(n-1,y+1)-Math.max(0,y-1)+1);
        x++;
        y++;
        int rx = Math.min(m,x+1),ry = Math.min(n,y+1);
        int lx = Math.max(0,x-2),ly = Math.max(0,y-2);
        int ans = sum[rx][ry]-sum[rx][ly]-sum[lx][ry]+sum[lx][ly];
        ans /=cnt;
        return ans;
    }
}
