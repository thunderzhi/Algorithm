package org.cxz.contest.LC2023Spring;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/22 14:57
 */
public class test0422c {

    public int adventureCamp(String[] expeditions) {
        Set<String> orignalset = new HashSet<>();
        if (!"".equals(expeditions[0])) {
            String[] split = expeditions[0].split("->");
            for (String s:split) {
                orignalset.add(s);
            }
        }
        int n = expeditions.length;
        int maxidx = 0,maxcnt =0;
        for (int i = 1; i < n; i++) {
            String[] split = expeditions[i].split("->");
            int cnt =0;
            for(String s: split){
                if(orignalset.contains(s)) continue;
                if("".equals(s))continue;
                System.out.println("add = " + s);
                orignalset.add(s);
                cnt++;
            }
            if(maxcnt<cnt){
                maxcnt = cnt;
                maxidx = i;
            }
        }
        return maxidx;
    }

}
