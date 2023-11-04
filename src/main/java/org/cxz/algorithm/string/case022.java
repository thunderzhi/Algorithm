package org.cxz.algorithm.string;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/11/4 18:22
 */
public class case022 {
    Map<Integer,List<String>> map;
    public List<String> generateParenthesis(int n) {
        map = new HashMap();
        List<String> ans = dfs(n+n);
        // List<String> ans = new ArrayList(list);
        return ans;
    }

    public List<String> dfs(int n){
        if(map.containsKey(n)) return map.get(n);
        if(n==0) return new ArrayList();
        if(n==2){
            List<String> list = new ArrayList();
            list.add("()");
            return list;
        }
        //n>2
        // ()
        Set<String> set = new HashSet();
        List<String> res = new ArrayList(); 
        for(int i = 2;i<n;i+=2){
            List<String> list1 = dfs(i);
            List<String> list2 = dfs(n-i);
            for(String s1 : list1){
                for(String s2 : list2){
                    if(set.add(s1+s2)){
                        res.add(s1+s2);
                    }
                    if(set.add(s2+s1)){
                        res.add(s2+s1);
                    }
                }
            }
        }
        List<String> list3 = dfs(n-2);
        for(String s: list3){
            s = "("+s+")";
            if(set.add(s)){
                res.add(s);
            }
        }

        map.put(n,res);
        return res;
    }
}
