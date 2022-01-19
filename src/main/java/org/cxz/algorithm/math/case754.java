package org.cxz.algorithm.math;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2022/1/19 11:46
 */
public class case754 {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = (int)Math.floor(2*target);
        while((1+k)*k/2<target){
            k++;
        }
        if((1+k)*k/2==target){
            return k;
        }
        int d = (1+k)*k/2-target;
        while (d%2==1){
            k++;
            d += k ;
        }
        return k;


    }
}
