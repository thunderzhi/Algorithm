package org.cxz.contest.test2023116dweek;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/10/28 21:42
 */
public class test1028b {
    public int minChanges(String s) {
        int ans = 0,n =s.length();
        for (int i = 0; i <n-1 ; i+=2) {
            if(s.charAt(i)==s.charAt(i+1))continue;
            ans+=1;
        }
        return ans;
    }
}
