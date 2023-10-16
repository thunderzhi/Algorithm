package org.cxz.contest.test2023115dweek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/14 22:29
 */
public class test1014b {
    int[] g;
    int max = -1,offset = 1000;
    Map<Integer,List<Integer>> memo;
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        // 0 1 0 1 0 1
        // 1 0 1 0 1 0
//        int[]
        memo = new HashMap<>();
        g = groups;
        List<Integer> list = dfs(n - 1, -1);
        List<String> ans = new ArrayList<>();
        for (int x: list) {
            ans.add(words[x]);
        }
        return ans;
    }
    // 0 not  1 chose
    public List<Integer> dfs(int idx,int pre){
        int k = idx*offset+pre;

        System.out.println("idx = " + idx+ " pre "+pre+ " k "+k );
        if(memo.containsKey(idx*offset+pre)){
            List<Integer> res = new ArrayList<>();
            List<Integer> mlist = memo.get(idx * offset + pre);
            for(int x: mlist){
                res.add(x);
            }
            System.out.println("idx = " + idx+ " pre "+pre+ " k "+k+" m: "+res.toString() );
            return res;
        }
        if(idx<0){
            List<Integer> res = new ArrayList<>();
            memo.put(idx*offset+pre,res);
            System.out.println("put idx = " + idx+ " pre "+pre+ " k "+k+" m: "+res.toString() );
            //res.add(null);
            return res;
        }
        List<Integer> list = new ArrayList<>();
        System.out.println("idx = " + idx+ " pre "+pre );
        if(pre== -1){

            // not chose
            List<Integer> res1 = dfs(idx-1,pre);
            // chose
            List<Integer> res2 = dfs(idx-1,idx);
            res2.add(idx);
            int l1 = res1.size(),l2 = res2.size();
            max = Math.max(max,Math.max(l1,l2));
            if(l1>=l2) list = res1;
            else list = res2;
        }
        else if(g[pre]==1){
            if(g[idx]==1){
                // not chose
                List<Integer> res1 = dfs(idx-1,pre);
                return res1;
            }
            else{
                //g[idx]==0
                // not chose
                List<Integer> res1 = dfs(idx-1,pre);
                // chose
                List<Integer> res2 = dfs(idx-1,idx);
                res2.add(idx);
                int l1 = res1.size(),l2 = res2.size();
                max = Math.max(max,Math.max(l1,l2));
                if(l1>=l2) list = res1;
                else list = res2;
            }
        }
        else {
            //pre==0
            if(g[idx]==0){
                // not chose
                List<Integer> res1 = dfs(idx-1,pre);
                return res1;
            }
            else{
                //g[idx]==0
                // not chose
                List<Integer> res1 = dfs(idx-1,pre);
                // chose
                List<Integer> res2 = dfs(idx-1,idx);
                res2.add(idx);
                int l1 = res1.size(),l2 = res2.size();
                max = Math.max(max,Math.max(l1,l2));
                if(l1>=l2) list = res1;
                else list = res2;
            }
        }
        memo.put(idx*offset+pre,list);
        System.out.println("put idx "+idx+" pre "+pre +" list = " + list.toString());
        return list;
    }

//3
//["e","a","b"]
//[0,0,1]
//4
//["a","b","c","d"]
//[1,0,1,1]

}
