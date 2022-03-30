package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/30 17:02
 */
public class case2151 {
    public int n;

    public int getcnt(int x){
        int cnt = 0;
        while(x>0){
            x&=(x-1);
            cnt++;
        }
        return cnt;
    }
    public boolean check(int[][] statements,int status){
        for(int i = 0;i<n;i++){
            if(((1<<i)&status)==0)continue;
            for(int j =0;j<n;j++){
                if(statements[i][j]==2) continue;
                // if(statements[i][j]==0&&(((1<<j)&status))!=0){
                //     return false;
                // }
                // if(statements[i][j]==1&&(((1<<j)&status))==0){
                //     return false;
                // }
                if(statements[i][j]!=(1&(status>>j))){
                    return false;
                }
            }
        }
        return true;
    }
    //ver1
    public int maximumGood(int[][] statements) {
        n = statements.length;
        int ans =0;
        for(int i =0,I=(1<<n);i<I;i++){
            if(!check(statements,i)) continue;
            ans = Math.max(ans,getcnt(i));
        }
        return ans;
    }
}
