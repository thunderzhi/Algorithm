package org.cxz.algorithm.array;

import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/4 15:30
 */
public class case1774b {

    // 一维优化
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n = toppingCosts.length;
        int[] val = toppingCosts;
        int min = Arrays.stream(baseCosts).min().getAsInt();
        if(min>=target) return min;
        int Cap = 2*target-min;
        boolean[] f = new boolean[Cap+1];
        //f[0][0]=true;
        //System.out.println("Cap = " + Cap);
        for(int i =0;i<baseCosts.length;i++){
            if(baseCosts[i]>Cap) continue;
            f[baseCosts[i]] = true;
        }

        int ans = min;
        for(int i =1;i<=n;i++){
            for(int j =Cap;j>0;j--){
                for(int k =0;k<=2&&j>=k*val[i-1];k++){
                    int t = j-k*val[i-1];
//                    System.out.println("k= "+k+" val["+(i-1)+"]="+val[i-1]+" i= "+i+" f[t:"+t+"] = " + f[t]);
                    f[j] |= f[t];
//                    System.out.println("--> k= "+k+" val["+(i-1)+"]="+val[i-1]+" i= "+i+" f[j:"+j+"] = " + f[j]);
                }
                //System.out.println("-------" + f[j]);
                if(f[j]){
//                    System.out.println("-------");
//                    System.out.println("TTT f["+j+"] = " + f[j]);
                    if(j==target) return target;
                    if(Math.abs(j-target)<=Math.abs(ans-target)){
                        if(Math.abs(j-target)==Math.abs(ans-target)){
                            ans = Math.min(ans,j);
                        }
                        else{
                            ans = j;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
