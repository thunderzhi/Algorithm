package org.cxz.contest.test104dweek;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/13 22:28
 */
public class test0513a {
    public int countSeniors(String[] details) {
        int ans = 0;
        for(String d: details){
            if(check(d))ans++;
        }
        return ans;
    }
    public boolean check(String s){
        String sub = s.substring(11, 13);
        int age = Integer.parseInt(sub);
        return age>60;
    }
}
