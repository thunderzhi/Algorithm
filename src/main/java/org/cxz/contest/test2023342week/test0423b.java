package org.cxz.contest.test2023342week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/4/23 10:29
 */
public class test0423a {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
//        int i = 24;
        int ans = (arrivalTime+delayedTime)% 24;
        return ans;
    }
}
