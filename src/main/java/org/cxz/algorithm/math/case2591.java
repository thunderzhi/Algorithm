package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/9/22 14:01
 */
public class case2591 {
    public int distMoney(int money, int children) {
        money -= children;
        if(money<0) return -1;
        int ans = Math.min(money/7,children);
        money -= ans*7;
        children -= ans;
        if(children==0&&money>0) return ans-1;
        if(children==1&&money==3) return ans-1;
        return ans;
    }
}
