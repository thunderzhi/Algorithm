package org.cxz.contest.test1126N;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/11/26 22:35
 */
public class test1126b {

    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        if(n%2==0) return n/2;
        return n;




    }
}
