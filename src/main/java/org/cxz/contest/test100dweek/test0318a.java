package org.cxz.contest.test100dweek;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/18 22:17
 */
public class test0318a {
    public static void main(String[] args) {
        int res = new test0318a().distMoney(16, 10);
        System.out.println("res = " + res);
    }
    public int distMoney(int money, int children) {

        if(money<children) return -1;
        int ans =0,k=children;
        if(money>children*8){
            ans = children-1;
            return ans;
        }
        if(money==children*8) return children;
        // money<child*8
        // x*8 + left(left>=(child-x)) = money
        //money-8x=left>=child-x
        //20 -16=4>3-2
        int cnt = 0;// money/8;
        int m = money%8;
        while(money-cnt*8>0){
            int c = cnt+1;
            int left = money - c*8;
            if(left<0) break;
            if(left<children-c) break;
            cnt = c;
        }
        if(money-cnt*8==4&&children-cnt==1)return ans =cnt-1;
        return ans=cnt;
//        System.out.println("ans = " + ans);
//        System.out.println("money = " + money);
//        System.out.println("k = " + k);
//        if (money==4&&k==1) return --ans;
//        return ans;
    }
}
