package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/2 15:19
 */
public class case822 {

    public int flipgame(int[] fronts, int[] backs) {
        int[] set = new int[2002];
        int INF = 1<<30;
        int n = fronts.length,min = INF;
        for(int i = 0;i<n;i++){
            if(fronts[i]== backs[i]){
                set[fronts[i]]++;
            }
        }
        for(int i = 0;i<n;i++){
            if(fronts[i]<min&&set[fronts[i]]==0){
                min = Math.min(min,fronts[i]);
            }
            if(backs[i]<min&&set[backs[i]]==0){
                min = Math.min(min,backs[i]);
            }
        }
        return min == INF?0:min;
    }
}
