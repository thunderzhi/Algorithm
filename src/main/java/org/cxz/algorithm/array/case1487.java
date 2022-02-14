package org.cxz.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/14 10:13
 */
public class case1487 {
    public String[] getFolderNames(String[] names) {
        String[] ans = new String[names.length];
        Map<String,Integer> map = new HashMap();
        for(int i = 0;i<ans.length;i++){

            if(!map.containsKey(names[i])){
                ans[i] = names[i];
                map.put(ans[i],1);
            }
            else{
                int cnt = map.get(names[i]);
                while(map.containsKey(names[i]+"("+cnt+")")){
                    cnt++;
                }
                ans[i] = names[i]+"("+cnt+")";
                map.put(ans[i],1);
                map.put(names[i],map.get(names[i])+1);
            }
        }
        return ans;
    }
}
