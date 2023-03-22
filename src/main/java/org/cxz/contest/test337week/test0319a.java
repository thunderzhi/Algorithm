package org.cxz.contest.test337week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/19 10:26
 */
public class test0319a {

    public int[] evenOddBit(int n) {
        int x = n,even =0,odd =0,k=0;
        while(x>0){
            if((x&1)==1){
                if(k%2==0){
                    even++;
                }
                else{
                    odd++;
                }
            }
            x>>=1;
            k++;
        }
        return new int[]{even,odd};
    }
}
