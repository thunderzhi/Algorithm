package org.cxz.contest.test106202306dweek.test105202305dweek;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/5/27 22:38
 */
public class test0527a {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int tot = prices[0]+prices[1];
        if(tot>money) return money;
        return money-tot;
    }
}
