package org.cxz.contest.test338week;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2023/3/26 10:31
 */
public class test0326a {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {

        int postcnt = numOnes+numZeros;
        if(k<= numOnes) return k;
        if(k>numOnes&&k<=postcnt) return numOnes;
        int remain = k - postcnt;
        int ans = numOnes- remain;
        return ans; 
    }
}
