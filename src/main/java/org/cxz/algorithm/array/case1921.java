package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/11 12:46
 */
public class case1921 {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];
        for(int i= 0;i<n;i++){
            if(dist[i]<=speed[i]){
                time[i] = 1;
            }
            else{
                time[i] =(dist[i]%speed[i]==0)?dist[i]/speed[i]:dist[i]/speed[i]+1;
            }
        }
        Arrays.sort(time);
        //System.out.println("time: "+ Arrays.toString(time));
        int ans = 1;
        int pos = 1;
        int min = 1;
        while(pos<n){
            if(time[pos]-min<=0){
                break;
            }
            min++;
            ans++;
            pos++;
        }
        return ans;
    }
}
