package org.cxz.algorithm.bit;

import java.util.HashMap;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/11/8 14:50
 */
public class case464 {
    public static void main(String[] args) {
        int m = 10;
        int d =11;
        boolean b = new case464().canIWin(m, d);
        System.out.println("b = " + b);
    }
    public HashMap<Integer, Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int total = desiredTotal;
        int n = maxChoosableInteger;
        if((1+n)*n/2<total){//miss
            return false;
        }
        int mask =0;
        map = new HashMap<>();
        return dfs(mask,n,total);
    }
    public boolean dfs(int mask, int n, int total){
        if(map.containsKey(mask)){
            return map.get(mask);//miss
        }
        for (int i = 1; i <= n ; i++) {
            if((mask&(1<<i))!=0){
                continue;
            }
            if(i>=total||!dfs(mask|(1<<i),n,total-i)){//miss
                map.put(mask,true);
                return true;
            }
        }
        map.put(mask,false);
        return false;
    }
}
