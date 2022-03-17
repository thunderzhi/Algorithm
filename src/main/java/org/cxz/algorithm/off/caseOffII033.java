package org.cxz.algorithm.off;

import java.util.*;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/17 10:41
 */
public class caseOffII033 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap();
        int n = strs.length;
        for(int i = 0; i<n;i++){
            String s = strs[i];
            String h = hash(s);
            if(!map.containsKey(h)){
                map.put(h,new ArrayList());
            }
            map.get(h).add(s);
        }
        List<List<String>> ans = new ArrayList();
        for(Map.Entry<String,List<String>> entry
                : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public String hash(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
