package org.cxz.algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/23 22:47
 */
public class case139 {
    // set
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String str : wordDict){
            min = Math.min(min,str.length());
            max = Math.max(max,str.length());
            set.add(str);
        }

        List<List<Integer>> mark = new ArrayList();
        for(int i=0;i<=s.length();i++){
            mark.add(new ArrayList());
        }
        process(s,mark,set,max,min);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;// new add
        for(int i = 1;i<dp.length;i++){
            if(dp[i]) continue;
            for(int ind :mark.get(i)){
                //System.out.println("i: "+i+" ind : "+ind);
                if(dp[i]) break;
                //dp[i] = dp[ind]&&(trie.search(s,ind,i-1));
                dp[i] =set.contains(s.substring(ind,i))&&dp[ind];
            }
        }
        return dp[s.length()];
    }
    public void process(String s, List<List<Integer>> mark, Set<String> set, int max, int min ){
        int n = s.length();
        for(int i = 0;i<=n-min;i++){//miss ==
            int right = i+min-1;//miss index -1
            while(right<n&&right-i<=max-1){// miss length
                // if(trie.search(s,i,right)){
                if(set.contains(s.substring(i,right+1))){
                    mark.get(right+1).add(i);
                }
                right++;
            }
        }
        return;
    }

    //ver dp
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[i]) break;
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];

    }
}2
