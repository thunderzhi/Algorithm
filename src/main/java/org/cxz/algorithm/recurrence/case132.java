package org.cxz.algorithm.recurrence;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/19 19:40
 */
public class case132 {

    public void extract(String s,int l ,int r,List<List<Integer>> mark ){
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            mark.get(r+1).add(l);
            l--;
            r++;
        }
        return;
    }

    public int minCut(String s) {
        List<List<Integer>> mark = new ArrayList();
        int n = s.length();
        for(int i = 0;i<=n;i++ ){
            mark.add(new ArrayList());
        }
        for(int i=0;i<n;i++){
            extract(s,i,i,mark);
            extract(s,i,i+1,mark);
        }
        int[] dp = new int[n+1];
        for(int i =1;i<=n;i++){
            dp[i]=i;
            for(int j : mark.get(i)){
                dp[i] = Math.min(dp[i],dp[j]+1);
            }
        }
        return dp[n]-1;
    }
}
