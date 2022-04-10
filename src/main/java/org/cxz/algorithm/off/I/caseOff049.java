package org.cxz.algorithm.off.I;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/10 23:34
 */
public class caseOff049 {

    //ver1
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int[] ans = new int[n+1];
        ans[0]=1;
        int ind = 1;
        int p2 = 0,p3 = 0,p5= 0;
        while(ind<n){
            int num = Math.min(2*ans[p2],Math.min(3*ans[p3],5*ans[p5]));
            ans[ind] = num;
            //System.out.println("ind: "+ind +" ="+num);
            while(2*ans[p2]<= num){ p2++; }
            while(3*ans[p3]<= num){ p3++; }
            while(5*ans[p5]<= num){ p5++; }
            ind++;
        }
        return ans[n-1];
    }
}
