package org.cxz.algorithm.graph;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/9/2 17:27
 */
public class case743 {
	
	public int[][] w;
    public int[] dist;
    public boolean[] vis;
    public int max;
    public int networkDelayTime(int[][] times, int n, int k) {
        w = new int[n+1][n+1];
        max = 1000000007;
        for(int i=0;i<=n;i++){
            Arrays.fill(w[i],max);
            w[i][i]=0;
        }        
        dist = new int[n+1];
        vis = new boolean[n+1];
        for(int i = 0;i<times.length;i++){
            int from = times[i][0];
            int to = times[i][1];
            w[from][to] = times[i][2];
            //System.out.println("w["+from+"]["+to+"]:"+w[from][to]);
        }
        dijstra(k,n);
        int ans =0;
        for(int i = 1;i<=n;i++){
            //System.out.println("dist["+i+"]:"+dist[i]);
            ans = Math.max(ans,dist[i]);
        }
        return ans>=max?-1:ans;
    }

    public void dijstra(int k,int n){
        Arrays.fill(dist,max);
        dist[k] =0;        
        for(int i =1;i<=n;i++){
            int ind = -1;
            for(int j =1;j<=n;j++){
                if(!vis[j]&&(ind==-1||dist[ind]>dist[j])){
                    ind = j;
                }
            }
            //System.out.println("vis["+ind+"]:"+ind);
            vis[ind] = true;
            for(int j=1;j<=n;j++){
                int tmp = dist[ind]+w[ind][j];
                //System.out.println("tmp:"+tmp+"dist["+j+"]:"+dist[j]);
                dist[j] = Math.min(dist[j],dist[ind]+w[ind][j]);
            }
            //System.out.println("dist:"+Arrays.toString(dist));
        }
        return;
    }
}
