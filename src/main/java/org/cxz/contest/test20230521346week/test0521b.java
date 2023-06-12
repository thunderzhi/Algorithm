package org.cxz.contest.test20230521346week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/21 10:17
 */
public class test0521b {
    public int minLength(String s) {

        while(s.contains("AB")||s.contains("CD")){
            s = s.replace("AB","");
            s = s.replace("CD","");
        }
        return s.length();
    }
}
