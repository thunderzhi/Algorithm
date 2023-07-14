package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description: contest107 Q3
 * @date 2023/7/14 20:22
 */
public class case2746 {
    String[] words;
    int n;
    int[][][] memo ;
    public int minimizeConcatenatedLength(String[] words) {
        this.words= words;
        n = words.length;
        if(n==1) return words[0].length();
        memo = new int[n][26][26];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<26;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        String w = words[0];
        int len = w.length();
        int res = dfs(1,w.charAt(0),w.charAt(len-1))+len;
        return res;
    }
    public int dfs(int ind,char left,char right){
        if(ind==n) return 0;
        if(memo[ind][left-'a'][right-'a']!=-1){
            return memo[ind][left-'a'][right-'a'];
        }

        String w = words[ind];
        int wl = w.length();
        // w+ s
        char c1 = w.charAt(0);
        char c2 = w.charAt(wl-1);
        int res1 = dfs(ind+1,c1,right)+(c2==left?-1:0);
        //s+w
        int res2 = dfs(ind+1,left,c2)+(c1==right?-1:0);
        int res = Math.min(res1,res2)+wl;
        return memo[ind][left-'a'][right-'a']= res;
    }
}
