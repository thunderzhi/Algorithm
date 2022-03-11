package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/3/11 12:47
 */
public class case1904 {

    //ver 1
    public int numberOfRounds(String startTime, String finishTime) {
        int st = convertToMinutes(startTime);
        int et = convertToMinutes(finishTime);
        if (et < st) {
            //ver 2
            //et += 60*24;
            return numberOfRounds(startTime, "24:00")
                    + numberOfRounds("00:00", finishTime);
        }
        if (st % 15 != 0) st += (15 - st % 15);
        return (et - st) / 15;
    }
    private int convertToMinutes(String time) {
        String[] strs = time.split(":");
        int hour = Integer.parseInt(strs[0]);
        int minute = Integer.parseInt(strs[1]);
        return hour * 60 + minute;
    }
}
