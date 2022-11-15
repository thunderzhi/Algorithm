package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/11/15 11:07
 */
public class case1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a, b)->{
            return b[1]-a[1];
        });
        int total = 0;
        int ans =0;
        for(int i = 0;i<boxTypes.length;i++){
            if(total>=truckSize)break;
            int[] it = boxTypes[i];
            int boxcnt = it[0];
            int volume = it[1];
            while(boxcnt>0&&total<truckSize){
                boxcnt--;
                total++;
                ans += volume;
            }
        }
        return ans;
    }
}
