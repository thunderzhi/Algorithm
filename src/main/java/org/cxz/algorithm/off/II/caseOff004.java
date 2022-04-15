package org.cxz.algorithm.off.II;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/4/15 15:50
 */
public class caseOff004 {

    public static void main(String[] args) {
        int[] arr = {-2,-2,1,1,4,1,4,4,-4,-2};
        int n=-2;
        for(int i=0;i<31&&n!=0;i++){
            System.out.println("n>>> "+i+" = " + Integer.toBinaryString((n>>>i)));
            System.out.println("n>>  "+i+" = " + Integer.toBinaryString((n>>i)));
        }
    }

    // space O1,time O(32n)
    public int singleNumber(int[] nums) {
        int n =31, ans = 0;
        for(int i= 0;i<=n;i++){
            int sum =0;
            for(int x:nums){
                if(((x>>>i)&1)==0)continue;
                sum^=1;
            }
            if(sum!=0){
                ans |= (1<<i);
            }
        }
        return ans;
    }
}
