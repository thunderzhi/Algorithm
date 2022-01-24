package org.cxz.algorithm.string;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/24 15:22
 */
public class case926 {

    //ver greedy
    public int minFlipsMonoIncr(String s) {
        int cnt0=0,cnt1 =0;
        int ans =0;
        for(int i = 0;i <s.length();i++){
            if(s.charAt(i)=='0'){
                cnt0++;
            }
        }
        ans  = cnt0;

        for(int i = 0;i <s.length();i++){
            if(s.charAt(i)=='1'){
                cnt1+=1;
            }
            else{
                cnt0-=1;
            }
            ans = Math.min(ans ,cnt0+cnt1);
        }
        return ans;
    }
}
