package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/29 13:04
 */
public class case1723 {

    public void dfs(int[] jobs,int ind,
                    int [] slot, int max, int[] ans ){
        if(ind== jobs.length){
            ans[0] = Math.min(max,ans[0]);
            return;
        }
        for(int i=0;i<slot.length;i++){
            if(slot[i]+jobs[ind]>ans[0]){continue;}
            slot[i]+=jobs[ind];
            dfs(jobs,ind+1,slot,Math.max(slot[i],max),ans);
            slot[i]-=jobs[ind];
            if(slot[i]==0)break;
        }
    }
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] slot = new int[k];
        int max = 0;
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(jobs,0,slot, 0,ans );
        return ans[0];
    }
}
