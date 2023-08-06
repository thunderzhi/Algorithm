package org.cxz.contest.test11020230805dweek;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/8/5 20:08
 */
public class test0805a {

    public int accountBalanceAfterPurchase(int purchaseAmount) {

        int l = purchaseAmount/10;
        int r = l+1;
        int low = l*10,high= r*10;
        if(high>100) return 100 - low;
        if(high -purchaseAmount<=purchaseAmount-low){
            return 100 - high;
        }
        return 100-low;


    }

}
