package org.cxz.algorithm.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/12/4 15:30
 */
public class case1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int n = toppingCosts.length;
        int[] val = toppingCosts;
        int min = Arrays.stream(baseCosts).min().getAsInt();
        if(min>=target) return min;
        int Cap = 2*target-min;
        boolean[][] f = new boolean[n+1][Cap+1];
        //f[0][0]=true;
        //System.out.println("Cap = " + Cap);
        for(int i =0;i<baseCosts.length;i++){
            if(baseCosts[i]>Cap) continue;
            f[0][baseCosts[i]] = true;
        }

        int ans = min;

        for(int i =1;i<=n;i++){
            for(int j =min;j<=Cap;j++){
                //剪枝 如果j>target&& j-target>target - ans 就不用继续了
                //if(j>target&&(j-target>target - ans)) break;
                for(int k =0;k<=2;k++){
                    int t = j-k*val[i-1];
                    if(t>=0){
                        //System.out.println("f["+(i-1)+"]["+t+"] = " + f[i-1][t]);
                        f[i][j] |= f[i-1][t];
                    }
                }


                if(f[i][j]){
                    // System.out.println("-------");
                    //  System.out.println("TTT f["+i+"]["+j+"] = " + f[i][j]);
                    if(j==target) return target;
                    if(Math.abs(j-target)<=Math.abs(ans-target)){
                        if(Math.abs(j-target)==Math.abs(ans-target)){
                            ans = Math.min(ans,j);
                        }
                        else{
                            ans = j;
                        }
                        if(j>target) break;
                    }
                }
            }

        }
        return ans;
    }
}
