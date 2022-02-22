package org.cxz.algorithm.recurrence;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/2/22 16:39
 */
public class case343 {

    public int max =0;
    public int integerBreak(int n) {
        for(int i=2;i<=n;i++){
            getMultiply(n,i);
        }
        return max;
    }
    public void getMultiply(int n,int k){
        int mod = n%k;
        int quotient = n/k;
        int product = 1;
        for(int i = 0;i<k;i++){
            product = product*(quotient+(i<mod?1:0));
        }
        if(product>max){
            max = product;
        }
        return;
    }
}
