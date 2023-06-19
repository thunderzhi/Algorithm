package org.cxz.contest.test349week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/6/4 10:25
 */
public class test0618a {


    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans =0;
        if(mainTank<5){
            return 10*mainTank;
        }
        int k =0;
        while(mainTank>=5){
            if(additionalTank==0)break;
            ans += 50;
            mainTank-=5;
            mainTank+=1;
            additionalTank--;
        }
        ans += mainTank*10;
        return ans;
        //5 -5 + 1 => 50+10
        //6 -5 + 1 => 50 + 20
        //9 -5 + 1 + 1=> 5-5 +4+1 +1  =>  50*2 + 20


    }
}
