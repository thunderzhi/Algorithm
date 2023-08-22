package org.cxz.contest.test20230820359week;

import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/20 10:30
 */
public class test0820a {

    public boolean isAcronym(List<String> words, String s) {
        int n = words.size();
        if(n!=s.length()) return false;
        for (int i = 0; i < n; i++) {
            if(words.get(i).charAt(0)!=s.charAt(i)) return false;
        }
        return true;

    }
}
