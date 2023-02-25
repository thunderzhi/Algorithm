package org.cxz.algorithm.array;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/2/23 14:48
 */
public class case2391 {

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = travel.length;
        long[] sum = new long[n+1];
        for(int i = 0;i<n;i++){
            sum[i+1] = sum[i]+ travel[i];
        }
        int ans = 0,prep =0,preg =0,prem=0;
        for(int i = 0;i<=n;i++){
            String gar = garbage[i];
            int cntp =0,cntg=0,cntm=0,idx=i;
            for(int j = 0;j<gar.length();j++){
                if(gar.charAt(j)=='G')cntg++;
                if(gar.charAt(j)=='M')cntm++;
                if(gar.charAt(j)=='P')cntp++;
            }
            if(cntg>0){
                ans +=cntg;
                ans += sum[i]-sum[preg] ;
                preg=i;
            }
            if(cntp>0){
                ans +=cntp;
                ans += sum[i]- sum[prep];
                prep=i;
            }
            if(cntm>0){
                ans +=cntm;
                ans += sum[i]- sum[prem];
                prem=i;
            }
        }
        return ans;
    }
}
