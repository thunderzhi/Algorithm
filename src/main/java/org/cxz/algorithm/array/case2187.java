package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/3 21:33
 */
public class case2187 {
    //region ver1 bymy binary
    //ver1 bymy binary
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0,r = (long)totalTrips*(long)time[0];
        for(int t :time){
            r = Math.max(r,((long)totalTrips)*((long)t));
        }
        long ans = binary(time,l,r,totalTrips);
        return ans;
        //return 1;
    }

    public long binary(int[] time,long l,long r,int totalTrips){
        long mid = 0;
        while(l<r){
            mid = l+(r-l)/2;
            if(check(mid,time,totalTrips)){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }


    public boolean check(long totaltime,int[] time,int totalTrips){
        long cnt = 0;
        for(int t: time){
            cnt +=  (totaltime/t);
            if(cnt>=totalTrips) return true;
        }
        return false;
    }
    //endregion

    //region ver2
    public long minimumTime2(int[] time, int totalTrips) {
        long l, r;
        l = 0;
        r = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
        return binnarSearch(time, l, r, (long) totalTrips);
    }

    private long binnarSearch(int[] time, long l, long r, long totalTrips) {
        while (l < r) {
            long mid = (l + r) / 2;
            if (check2(mid, time) < totalTrips) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
    private long check2(long mid, int[] time) {
        long ans = 0;
        for (int x : time) {
            ans += mid / x;
        }
        return ans;
    }
    //endregion


}
